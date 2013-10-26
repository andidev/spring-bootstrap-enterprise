package org.andidev.applicationname.entity;

import org.andidev.applicationname.entity.enums.Role;
import java.io.Serializable;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Setter
@Getter
public class User extends IdUuidVersionEntity implements Serializable {

    private String firstName;
    private String lastName;
    @Column(unique = true)
    @NonNull
    private String username;
    @NonNull
    private String password;
    private String email;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> userRoles = EnumSet.noneOf(Role.class);
    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Group> groups = new HashSet();
    @OneToMany
    private Set<PreferenceValue> preferenceValues = new HashSet();

    public Set<Role> getRoles() {
        Set<Role> roles = EnumSet.noneOf(Role.class);
        roles.addAll(getUserRoles());
        roles.addAll(getGroupRoles());
        return roles;
    }

    private Set<Role> getGroupRoles() {
        Set<Role> roles = EnumSet.noneOf(Role.class);
        for (Group group : getGroups()) {
            roles.addAll(group.getGroupRoles());
        }
        return roles;
    }
}
