package org.andidev.test.domain;

import javax.persistence.Entity;
import javax.persistence.Version;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author anders
 */
@Entity
//@Table(schema="test")
@Data
@ToString(callSuper=true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Person extends AbstractPersistable<Long> implements java.io.Serializable {
    
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @Version
    private Long version;

}
