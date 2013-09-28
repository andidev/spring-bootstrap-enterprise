package org.andidev.applicationname.service;

import javax.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.andidev.applicationname.entity.System;
import org.andidev.applicationname.repository.SystemRepository;
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
public class SystemService {

    @Inject
    private SystemRepository systemRepository;

    public Boolean create(System system) {
        // create entity
        System saved = systemRepository.save(system);
        if (saved == null) {
            return false;
        }

        return true;
    }

    public Boolean update(System system) {
        // find entity
        System existingSystem = systemRepository.findOne(system.getId());
        if (existingSystem == null) {
            return false;
        }

        // change entity
        existingSystem.setName(system.getName());

        // save entity
        System saved = systemRepository.save(existingSystem);
        if (saved == null) {
            return false;
        }

        return true;
    }

    public Boolean delete(System system) {
        // find entity
        System existingSystem = systemRepository.findOne(system.getId());
        if (existingSystem == null) {
            return false;
        }

        // delete entity
        systemRepository.delete(existingSystem);
        System deletedSystem = systemRepository.findOne(system.getId());
        if (deletedSystem != null) {
            return false;
        }

        return true;
    }
}
