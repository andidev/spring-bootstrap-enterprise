package org.andidev.applicationname.entity;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Setter
@Getter
@MappedSuperclass
public class IdVersionEntity extends  AbstractPersistable<Long> {
    @Version
    @Setter(AccessLevel.PROTECTED)
    private Long version;
    
    @Override
    public String toString(){
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
