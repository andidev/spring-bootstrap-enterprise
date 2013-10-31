package org.andidev.applicationname.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.envers.Audited;
import lombok.*;
import static lombok.AccessLevel.*;

@Entity
@Audited
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@Setter
@Getter
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
