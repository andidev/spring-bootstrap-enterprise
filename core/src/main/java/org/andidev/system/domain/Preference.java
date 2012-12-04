package org.andidev.system.domain;

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
public class Preference implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PROTECTED)
    private Long id;
    private String name;
    @ManyToOne
    @NonNull
    private Service service;
    private Boolean isSystemPreference;
    private Boolean isCompanyPreference;
    private Boolean isUserPreference;
}
