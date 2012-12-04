package org.andidev.test.repository;

import org.andidev.test.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 *
 * @author anders
 */
public interface PersonRepository extends JpaRepository<Person, Long>, QueryDslPredicateExecutor<Person> {

    Person findById(Long id);

    Page<Person> findByFirstNameLike(String yyy, Pageable pageable);

    Page<Person> findByLastNameLike(String yyy, Pageable pageable);
}
