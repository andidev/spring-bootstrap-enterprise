package org.andidev.applicationname.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.*;

/**
 *
 * @author anders
 */
@Entity
//@Table(schema="opinion")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class OpinionTag extends IdEntity implements Serializable {
    @NonNull
    private String name;
    @ManyToMany(mappedBy = "opinionTags")
    private Set<Opinion> opinions = new HashSet();
}
