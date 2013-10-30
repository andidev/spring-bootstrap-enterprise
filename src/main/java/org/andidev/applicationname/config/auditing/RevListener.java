package org.andidev.applicationname.config.auditing;

import org.andidev.applicationname.util.ApplicationUtils;
import org.andidev.applicationname.entity.User;
import org.hibernate.envers.RevisionListener;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class RevListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {

        // get current user
        String currentUsername = ApplicationUtils.getCurrentUsername();
        User currentUser = ApplicationUtils.getCurrentUser();

        // set current user
        RevEntity revEntity = (RevEntity) revisionEntity;
        revEntity.setUsername(currentUsername);
        revEntity.setUser(currentUser);

    }
}