package org.andidev.applicationname.service;

import java.util.List;
import javax.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.Group;
import org.andidev.applicationname.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class GroupService {

    @Inject
    private GroupRepository groupRepository;

    public Group create(Group group) {
        log.info("Creating {} group", group.getGroupname());

        if (groupRepository.findByGroupname(group.getGroupname()) != null) {
            throw new RuntimeException("Cannot create group with groupname  \"" + group.getGroupname() + "\" , the groupname is already in use by another group.");
        }

        // create entity
        return groupRepository.save(group);
    }

    public Group update(Group group) {
        if (groupRepository.findByIdNotAndGroupname(group.getId(), group.getGroupname()) != null) {
            throw new RuntimeException("Cannot update group with groupname  \"" + group.getGroupname() + "\" , the groupname is already in use by another group.");
        }

        // save entity
        return groupRepository.save(group);
    }

    public void delete(Group group) {
        groupRepository.delete(group);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }
}
