package org.andidev.test.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.andidev.test.domain.Person;
import org.andidev.test.repository.PersonRepository;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anders
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional
@Slf4j
public class OptimisticLockingServiceTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;
    //private PersonService personServiceMock;
    //private PersonRepository personRepositoryMock;

    @Before
    public void init() {
    }

    @Test(expected = HibernateOptimisticLockingFailureException.class)
    public void testOptimisticLockingWhithVersion() throws Exception {
        //given
        Person person = new Person("Firstname", "Lastname");
        personService.create(person);
        log.info("After create: version = {}", personRepository.findOne(person.getId()).getVersion().toString());
        log.info("After create: person = {}", personRepository.findOne(person.getId()));

        //when
        Person personVersion0 = personRepository.findOne(person.getId());

        jdbcTemplate.update(
                "UPDATE "
                + "    person "
                + "SET "
                + "    version = " + person.getVersion() + 1 + " " // version = 1
                + "WHERE "
                + "    id = " + person.getId()); // update person to version 1
        log.info("After jdbcTemplate version update: version = {}", personRepository.findOne(person.getId()).getVersion().toString());
        log.info("After jdbcTemplate version update: person = {}", personRepository.findOne(person.getId()));

        personVersion0.setFirstName("Firstname Updated");
        personService.update(personVersion0);  // try to update entity person in version 0 to version 2
        log.info("After firstName update: version = {}", personRepository.findOne(person.getId()).getVersion().toString());
        log.info("After firstName update: person = {}", personRepository.findOne(person.getId()));

        //then
    }

    @Test
    public void testOptimisticLockingNoVersionUpdate() throws Exception {
        //given
        Person person = new Person("Firstname", "Lastname");
        personService.create(person);
        log.info("After create: version = {}", personRepository.findOne(person.getId()).getVersion().toString());
        log.info("After create: person = {}", personRepository.findOne(person.getId()));

        //when
        Person personVersion0 = personRepository.findOne(person.getId());

        jdbcTemplate.update(
                "UPDATE "
                + "    person "
                + "SET "
                + "    lastName = 'Lastname Updated' "
                + "WHERE "
                + "    id = " + person.getId()); // update person without updating version
        log.info("After jdbcTemplate lastName update: version = {}", personRepository.findOne(person.getId()).getVersion().toString());
        log.info("After jdbcTemplate lastName update: person = {}", personRepository.findOne(person.getId()));

        personVersion0.setFirstName("Firstname Updated");
        personService.update(personVersion0);  // try to update entity person in version 0 to version 2
        log.info("After firstName update: version = {}", personRepository.findOne(person.getId()).getVersion().toString());
        log.info("After firstName update: person = {}", personRepository.findOne(person.getId()));

        //then
        Person currentPerson = personRepository.findOne(person.getId());
        assertEquals(currentPerson.getId(), person.getId());
        assertEquals(currentPerson.getFirstName(), "Firstname Updated");
        assertEquals(currentPerson.getLastName(), "Lastname"); // note that jdbcTemplate lastName = 'Lastname Updated' update is overwritten
        assertEquals(currentPerson.getVersion().longValue(), 1);
    }
}
