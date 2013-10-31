package org.andidev.applicationname.entity.abstracts;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;
import static org.apache.commons.lang3.builder.ToStringStyle.*;


@Setter
@Getter
@MappedSuperclass
public class IdVersionEntity extends  AbstractPersistable<Long> {
    @Version
    @Setter(AccessLevel.PROTECTED)
    private Long version;
    
    @Override
    public String toString(){
        return ReflectionToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
