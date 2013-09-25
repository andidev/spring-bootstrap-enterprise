package org.andidev.applicationname.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PreUpdate;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 *
 * @author anders
 */
@Data
@Embeddable
public class ModificationInfo implements Serializable {

    @Column(insertable = false, updatable = true)
    private String lastModifiedBy;
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    @Column(insertable = false, updatable = true)
    private DateTime lastModifiedDate;

    @PreUpdate
    void onPersist() {
        this.setLastModifiedDate(new DateTime());
    }
}
