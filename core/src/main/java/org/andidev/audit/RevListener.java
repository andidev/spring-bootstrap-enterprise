package org.andidev.audit;

import org.andidev.system.domain.User;
import org.andidev.system.repository.UserRepository;
import org.hibernate.envers.RevisionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 *
 * @author anders
 *
 * @link http://www.javafreedom.org/?p=414
 */
@Configurable
public class RevListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {

        // get current user
        String currentUsername = UserHolder.getUsername();
        User currentUser = UserHolder.getUser();

        // set current user
        RevEntity revEntity = (RevEntity) revisionEntity;
        revEntity.setUsername(currentUsername);
        revEntity.setUser(currentUser);

    }
}