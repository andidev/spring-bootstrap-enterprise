package org.andidev.applicationname.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author anders
 */
@Entity
//@Table(schema="system")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Setter(AccessLevel.PROTECTED)
    private Long id;
    @OneToOne
    @NonNull
    private User user;
    @NonNull
    private Integer role;
}
