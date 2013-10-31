package org.andidev.applicationname.entity;

import org.andidev.applicationname.entity.abstracts.IdUuidVersionEntity;
import java.io.Serializable;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import static lombok.AccessLevel.*;
import lombok.Getter;

@Entity
@Audited
@NoArgsConstructor(access = PROTECTED)
//@RequiredArgsConstructor
@Setter
@Getter
public class PreferenceValue extends IdUuidVersionEntity implements Serializable {
    @ManyToOne
//    @Audited(targetAuditMode = NOT_AUDITED)
    private Preference preference;
    private String value;
}
