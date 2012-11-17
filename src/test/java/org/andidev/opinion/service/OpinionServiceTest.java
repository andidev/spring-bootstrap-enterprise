package org.andidev.opinion.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.andidev.opinion.domain.Opinion;
import org.andidev.opinion.repository.OpinionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;
import org.junit.Ignore;
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
@Ignore
public class OpinionServiceTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private OpinionRepository opinionRepository;
    @Autowired
    private OpinionService opinionService;
    //private OpinionService opinionServiceMock;
    //private OpinionRepository opinionRepositoryMock;

    @Before
    public void init() {
        //opinionRepositoryMock = mock(OpinionRepository.class);
        //opinionServiceMock = new OpinionService(opinionRepositoryMock);
    }

    @Test
    public void testCreate() throws Exception {
        //given
        Opinion opinion = new Opinion("Test Header", "Test Text");

        //when
        opinionService.create(opinion);

        //then
        Opinion createdOpinion = opinionRepository.findOne(opinion.getId());
        assertEquals(createdOpinion.getId(), opinion.getId());
        assertEquals(createdOpinion.getHeader(), opinion.getHeader());
        assertEquals(createdOpinion.getText(), opinion.getText());
    }

    @Test
    public void testUpdate() throws Exception {
        //given
        Opinion opinion = new Opinion("Test Header", "Test Text");
        opinionService.create(opinion);

        //when
        Opinion createdOpinion = opinionRepository.findOne(opinion.getId());
        createdOpinion.setHeader("Modified Header");
        createdOpinion.setText("Modified Text");
        opinionService.update(createdOpinion);

        //then
        Opinion modifiedOpinion = opinionRepository.findOne(opinion.getId());
        assertEquals(modifiedOpinion.getId(), opinion.getId());
        assertEquals(modifiedOpinion.getHeader(), opinion.getHeader());
        assertEquals(modifiedOpinion.getText(), opinion.getText());
    }

    @Test
    public void testJdbcTemplate() throws Exception {
        //given
        Opinion opinion = new Opinion("Test Header", "Test Text");
        opinionService.create(opinion);

        //when
        Long createdOpinionId = jdbcTemplate.queryForLong("select id from opinion where id = " + opinion.getId().toString());
        String createdOpinionHeader = jdbcTemplate.queryForObject("select header from opinion where id = " + opinion.getId().toString(), String.class);
        String createdOpinionText = jdbcTemplate.queryForObject("select text from opinion where id = " + opinion.getId().toString(), String.class);

        //then
        assertEquals(createdOpinionId, opinion.getId());
        assertEquals(createdOpinionHeader, opinion.getHeader());
        assertEquals(createdOpinionText, opinion.getText());
    }

    @Test
    public void testEntityManager() throws Exception {
        //given
        Opinion opinion = new Opinion("Test Header", "Test Text");
        opinionService.create(opinion);

        //when
        Opinion createdOpinion = (Opinion) entityManager.createQuery("from Opinion o where o.id = :id").setParameter("id", new Long(opinion.getId())).getSingleResult();


        //then
        assertEquals(createdOpinion.getId(), opinion.getId());
        assertEquals(createdOpinion.getHeader(), opinion.getHeader());
        assertEquals(createdOpinion.getText(), opinion.getText());
    }

}
