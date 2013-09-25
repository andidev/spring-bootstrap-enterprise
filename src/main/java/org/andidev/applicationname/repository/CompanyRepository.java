package org.andidev.applicationname.repository;

import org.andidev.applicationname.domain.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author anders
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByCompanyname(String companyname);

    Page<Company> findByCompanynameLike(String companyname, Pageable pageable);

    Page<Company> findByNameLike(String name, Pageable pageable);

}
