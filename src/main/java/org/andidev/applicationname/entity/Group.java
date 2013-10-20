package org.andidev.applicationname.entity;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.andidev.applicationname.entity.enums.Role;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Setter
@Getter
public class Group extends IdUuidVersionEntity implements Serializable {

    @Column(unique = true)
    @NonNull
    private String groupname;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> groupRoles = EnumSet.noneOf(Role.class);
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> users = new HashSet();
    @OneToMany
    private Set<PreferenceValue> preferenceValues = new HashSet();
}
