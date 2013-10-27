package org.andidev.applicationname.config.audit;

import org.andidev.applicationname.entity.User;
import org.hibernate.envers.RevisionListener;
import org.springframework.beans.factory.annotation.Configurable;

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