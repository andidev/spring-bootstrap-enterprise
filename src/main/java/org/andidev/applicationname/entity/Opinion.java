package org.andidev.applicationname.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author anders
 */
@Entity
//@Table(schema="opinion")
@Data
@ToString(callSuper=true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Audited
public class Opinion extends AbstractPersistable<Long> implements java.io.Serializable {

    @Column(nullable = false, length = 20)
    @NonNull
    private String header;
    @Column(nullable = false, length = 250)
    @NonNull
    private String text;
    @ManyToMany
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Set<OpinionTag> opinionTags = new HashSet();
    @Version
    private Long version;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private User user;
    @ManyToOne
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Opinion parentOpinion;
    @OneToMany(mappedBy = "parentOpinion")
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Set<Opinion> childOpinions;
}