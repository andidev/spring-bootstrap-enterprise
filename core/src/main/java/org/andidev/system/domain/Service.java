package org.andidev.system.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
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
public class Service implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PROTECTED)
    private Long id;
    @NonNull
    private String name;
    @OneToMany(mappedBy = "service")
    private Set<Preference> preferences = new HashSet();
    private Boolean isSystemService;
    private Boolean isCompanyService;
    private Boolean isUserService;
}
