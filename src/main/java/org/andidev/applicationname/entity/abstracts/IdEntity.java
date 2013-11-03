package org.andidev.applicationname.entity.abstracts;

import javax.persistence.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;
import static org.apache.commons.lang3.builder.ToStringStyle.*;
import org.hibernate.LazyInitializationException;

@MappedSuperclass
public class IdEntity extends AbstractPersistable<Long> {

    @Override
    public String toString() {
        try {
            return ReflectionToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
        } catch (LazyInitializationException e) {
            return new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                    .append("id", getId())
                    .toString();
        }
    }
}
