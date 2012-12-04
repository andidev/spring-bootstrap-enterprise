package org.andidev.audit;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.andidev.system.domain.User;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

/**
 *
 * @author anders
 *
 * @link http://www.javafreedom.org/?p=414
 */
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