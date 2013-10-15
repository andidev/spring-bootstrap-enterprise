package org.andidev.applicationname.entity;

import java.util.UUID;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@EqualsAndHashCode(of = "uuid")
@MappedSuperclass
public class IdUuidVersionEntity extends  AbstractPersistable<Long> {

    @Column(unique = true)
    @Setter(AccessLevel.PROTECTED)
    private String uuid = UUID.randomUUID().toString();
    @Version
    @Setter(AccessLevel.PROTECTED)
    private Long version;
}
