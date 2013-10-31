package org.andidev.applicationname.entity;

import org.andidev.applicationname.entity.abstracts.IdUuidVersionEntity;
import java.io.Serializable;
import javax.persistence.*;
import lombok.*;
import static lombok.AccessLevel.PROTECTED;
import org.hibernate.envers.Audited;

@Entity
@Audited
@NoArgsConstructor(access = PROTECTED)
//@RequiredArgsConstructor
@Setter
@Getter
public class Preference extends IdUuidVersionEntity implements Serializable {

    private String name;
//    private Boolean isGroupPreference;
//    private Boolean isUserPreference;
}
