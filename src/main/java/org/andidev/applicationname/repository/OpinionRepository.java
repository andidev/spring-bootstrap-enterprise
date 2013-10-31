package org.andidev.applicationname.repository;

import org.andidev.applicationname.entity.Opinion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface OpinionRepository extends JpaRepository<Opinion, Long>, QueryDslPredicateExecutor<Opinion> {

    Opinion findById(Long id);

    Page<Opinion> findByHeaderLike(String text, Pageable pageable);

    Page<Opinion> findByTextLike(String text, Pageable pageable);
}
