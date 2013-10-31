package org.andidev.applicationname.entity.abstracts;

import java.util.UUID;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

@EqualsAndHashCode(of = "uuid", callSuper = false)
@Setter
@Getter
@MappedSuperclass
public class IdUuidVersionEntity extends  AbstractPersistable<Long> {

    @Column(unique = true)
    @Setter(AccessLevel.PROTECTED)
    private String uuid = UUID.randomUUID().toString();
    @Version
    @Setter(AccessLevel.PROTECTED)
    private Long version;

    @Override
    public String toString(){
        return ReflectionToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }

}
