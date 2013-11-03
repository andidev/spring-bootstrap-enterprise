package org.andidev.applicationname.config.auditing;

import static org.andidev.applicationname.util.ApplicationUtils.*;
import org.hibernate.envers.RevisionListener;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class RevListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        // Set current username and user
        RevEntity revEntity = (RevEntity) revisionEntity;
        revEntity.setUsername(getUsername());
        revEntity.setUser(getUser());

    }
}