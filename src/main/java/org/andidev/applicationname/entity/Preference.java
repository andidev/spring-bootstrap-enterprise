package org.andidev.applicationname.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;
import static lombok.AccessLevel.PROTECTED;
import org.andidev.applicationname.entity.abstracts.IdEntity;

@Entity
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@Setter
@Getter
public class Preference extends IdEntity implements Serializable {

    @NonNull
    private String name;
    private Boolean isGroupPreference;
    private Boolean isUserPreference;
}
