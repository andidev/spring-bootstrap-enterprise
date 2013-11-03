package org.andidev.applicationname.entity.abstracts;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.andidev.applicationname.entity.User;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import static org.apache.commons.lang3.builder.ToStringStyle.*;
import org.hibernate.LazyInitializationException;

@EqualsAndHashCode(of = "uuid", callSuper = false)
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class IdUuidVersionAuditableEntity extends AbstractAuditable<User, Long> {

    @Column(unique = true)
    @Setter(AccessLevel.PROTECTED)
    private String uuid = UUID.randomUUID().toString();
    @Version
    @Setter(AccessLevel.PROTECTED)
    private Long version;

    @Override
    public String toString() {
        try {
            return ReflectionToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
        } catch (LazyInitializationException e) {
            return new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                    .append("id", getId())
                    .append("uuid", getUuid())
                    .append("version", getVersion())
                    .toString();
        }
    }
}
