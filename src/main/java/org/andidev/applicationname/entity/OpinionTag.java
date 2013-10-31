package org.andidev.applicationname.entity;

import org.andidev.applicationname.entity.abstracts.IdUuidVersionEntity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@Setter
@Getter
public class OpinionTag extends IdUuidVersionEntity implements Serializable {
    @NonNull
    private String name;
    @ManyToMany(mappedBy = "opinionTags")
    private Set<Opinion> opinions = new HashSet();
}
