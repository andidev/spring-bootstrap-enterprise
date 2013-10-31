package org.andidev.applicationname.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;
import org.andidev.applicationname.entity.abstracts.IdEntity;

@Entity
//@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@Setter
@Getter
public class PreferenceValue extends IdEntity implements Serializable {
    @ManyToOne
    private Preference preference;
    private String value;
}
