package org.andidev.applicationname.config.auditing;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.andidev.applicationname.entity.User;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@RevisionEntity(RevListener.class)
public class RevEntity extends DefaultRevisionEntity {

    @Getter 
    @Setter
    private String username;
    @Getter 
    @Setter
    @ManyToOne
    private User user;
}