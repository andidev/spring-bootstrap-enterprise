package org.andidev.applicationname.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.*;
import static lombok.AccessLevel.*;
import org.andidev.applicationname.entity.abstracts.IdEntity;

@Entity
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@Setter
@Getter
public class Service extends IdEntity implements Serializable {

    @NonNull
    private String name;
    private Boolean isSystemService;
    private Boolean isCompanyService;
    private Boolean isUserService;
    @OneToMany
    private Set<Preference> preferences = new HashSet();
}
