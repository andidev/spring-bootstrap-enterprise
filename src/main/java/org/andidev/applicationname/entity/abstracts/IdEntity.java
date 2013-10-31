package org.andidev.applicationname.entity.abstracts;

import javax.persistence.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

@MappedSuperclass
public class IdEntity extends  AbstractPersistable<Long> {
    
    @Override
    public String toString(){
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
