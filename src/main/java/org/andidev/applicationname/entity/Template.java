package org.andidev.applicationname.entity;

import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.*;
import static lombok.AccessLevel.*;
import static org.hibernate.envers.RelationTargetAuditMode.*;

/**
 *
 * @author anders
 */
@Entity
//@Table(schema="test")
@Data
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
public class Template extends AbstractPersistable<Long> implements java.io.Serializable {

    @NonNull
    private String field;
}