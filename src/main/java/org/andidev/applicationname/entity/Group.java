package org.andidev.applicationname.entity;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.andidev.applicationname.entity.enums.Role;
import org.hibernate.envers.Audited;
import static javax.persistence.CascadeType.*;
import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.*;
import static lombok.AccessLevel.*;
import org.andidev.applicationname.entity.abstracts.IdEntity;
import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@Setter
@Getter
public class Group extends IdEntity implements Serializable {

    @Column(unique = true)
    @NonNull
    private String groupname;
    @ElementCollection(targetClass = Role.class, fetch = EAGER)
    @Enumerated(STRING)
    private Set<Role> groupRoles = EnumSet.noneOf(Role.class);
    @ManyToMany(cascade = ALL, fetch = LAZY)
    private Set<User> users = new HashSet();
    @OneToMany
    @Audited(targetAuditMode = NOT_AUDITED)
    private Set<PreferenceValue> preferenceValues = new HashSet();
}
