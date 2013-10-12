package org.andidev.applicationname.repository;

import org.andidev.applicationname.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author anders
 */
public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findByName(String groupname);

    Page<Group> findByNameLike(String name, Pageable pageable);

}
