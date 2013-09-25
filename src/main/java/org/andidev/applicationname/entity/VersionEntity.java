package org.andidev.applicationname.entity;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 *
 * @author anders
 */
@Data
@MappedSuperclass
public class VersionEntity {
    @Version
    @Setter(AccessLevel.PROTECTED)
    private Long version;
}
