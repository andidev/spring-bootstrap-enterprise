package org.andidev.applicationname.entity;

import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author anders
 */
@Entity
//@Table(schema="test")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Template extends AbstractPersistable<Long> implements java.io.Serializable {

    @NonNull
    private String field;
}