package org.andidev.test.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.andidev.test.domain.Person;
import org.andidev.test.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anders
 */
@Service
@Transactional
@NoArgsConstructor
@AllArgsConstructor
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Boolean create(Person person) {
        // create entity
        Person saved = personRepository.save(person);
        if (saved == null) {
            return false;
        }

        return true;
    }

    public Boolean update(Person person) {
        // find entity
        Person existingPerson = personRepository.findById(person.getId());
        if (existingPerson == null) {
            return false;
        }

        // change entity
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());

        // save entity
        Person saved = personRepository.save(existingPerson);
        if (saved == null) {
            return false;
        }

        return true;
    }

    public Boolean delete(Person person) {
        // find entity
        Person existingPerson = personRepository.findById(person.getId());
        if (existingPerson == null) {
            return false;
        }

        // delete entity
        personRepository.delete(existingPerson);
        Person deletedPerson = personRepository.findById(person.getId());
        if (deletedPerson != null) {
            return false;
        }

        return true;
    }

}
