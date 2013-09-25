package org.andidev.applicationname.repository;

import org.andidev.applicationname.domain.Template;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 *
 * @author anders
 */
public interface TemplateRepository extends JpaRepository<Template, Long>, QueryDslPredicateExecutor<Template> {

    Template findById(Long id);

    Page<Template> findByFieldLike(String text, Pageable pageable);
}
