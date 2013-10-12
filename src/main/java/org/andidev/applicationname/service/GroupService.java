package org.andidev.applicationname.service;

import javax.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.andidev.applicationname.entity.Group;
import org.andidev.applicationname.repository.GroupRepository;
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
public class GroupService {

    @Inject
    private GroupRepository groupRepository;

    public Boolean create(Group Group) {
        // create entity
        Group saved = groupRepository.save(Group);
        if (saved == null) {
            return false;
        }

        return true;
    }

    public Boolean update(Group Group) {
        // find entity
        Group existingGroup = groupRepository.findOne(Group.getId());
        if (existingGroup == null) {
            return false;
        }

        // change entity
        existingGroup.setName(Group.getName());

        // save entity
        Group saved = groupRepository.save(existingGroup);
        if (saved == null) {
            return false;
        }

        return true;
    }

    public Boolean delete(Group Group) {
        // find entity
        Group existingGroup = groupRepository.findOne(Group.getId());
        if (existingGroup == null) {
            return false;
        }

        // delete entity
        groupRepository.delete(existingGroup);
        Group deletedGroup = groupRepository.findOne(Group.getId());
        if (deletedGroup != null) {
            return false;
        }

        return true;
    }
}
