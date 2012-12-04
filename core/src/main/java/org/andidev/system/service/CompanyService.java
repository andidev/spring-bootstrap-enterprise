package org.andidev.system.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.andidev.system.domain.Company;
import org.andidev.system.repository.CompanyRepository;
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
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Boolean create(Company Company) {
        // create entity
        Company saved = companyRepository.save(Company);
        if (saved == null) {
            return false;
        }

        return true;
    }

    public Boolean update(Company Company) {
        // find entity
        Company existingCompany = companyRepository.findOne(Company.getId());
        if (existingCompany == null) {
            return false;
        }

        // change entity
        existingCompany.setName(Company.getName());

        // save entity
        Company saved = companyRepository.save(existingCompany);
        if (saved == null) {
            return false;
        }

        return true;
    }

    public Boolean delete(Company Company) {
        // find entity
        Company existingCompany = companyRepository.findOne(Company.getId());
        if (existingCompany == null) {
            return false;
        }

        // delete entity
        companyRepository.delete(existingCompany);
        Company deletedCompany = companyRepository.findOne(Company.getId());
        if (deletedCompany != null) {
            return false;
        }

        return true;
    }
}
