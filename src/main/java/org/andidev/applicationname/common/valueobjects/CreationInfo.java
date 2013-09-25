package org.andidev.applicationname.common.valueobjects;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 *
 * @author anders
 */
@Data
@Embeddable
public class CreationInfo implements Serializable {

    @Column(insertable = true, updatable = false)
    private String createdBy;
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    @Column(insertable = true, updatable = false)
    private DateTime createdDate;

    @PrePersist
    void onCreate() {
        this.setCreatedDate(new DateTime());
    }
}
