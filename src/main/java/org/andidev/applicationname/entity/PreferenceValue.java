package org.andidev.applicationname.entity;

import org.andidev.applicationname.entity.abstracts.IdUuidVersionEntity;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.envers.Audited;
import lombok.*;
import static lombok.AccessLevel.*;

@Entity
@Audited
//@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@Setter
@Getter
public class PreferenceValue extends IdUuidVersionEntity implements Serializable {
    @ManyToOne
    private Preference preference;
    private String value;
}
