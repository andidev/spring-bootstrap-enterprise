package org.andidev.applicationname.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.*;
import static lombok.AccessLevel.PROTECTED;
import org.hibernate.envers.Audited;
import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

@Entity
@Audited
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@Setter
@Getter
public class Opinion extends IdUuidVersionAuditableEntity implements Serializable {

    @Column(nullable = false, length = 20)
    @NonNull
    private String header;
    @Column(nullable = false, length = 250)
    @NonNull
    private String text;
    @ManyToMany
    @Audited(targetAuditMode = NOT_AUDITED)
    private Set<OpinionTag> opinionTags = new HashSet();
    @ManyToOne
    @Audited(targetAuditMode = NOT_AUDITED)
    private User user;
    @ManyToOne
    @Audited(targetAuditMode = NOT_AUDITED)
    private Opinion parentOpinion;
    @OneToMany(mappedBy = "parentOpinion")
    @Audited(targetAuditMode = NOT_AUDITED)
    private Set<Opinion> childOpinions;
}