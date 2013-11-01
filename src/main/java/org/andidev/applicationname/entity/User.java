package org.andidev.applicationname.entity;

import org.andidev.applicationname.entity.enums.Role;
import java.io.Serializable;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.*;
import static lombok.AccessLevel.*;
import org.andidev.applicationname.entity.abstracts.IdEntity;
import org.joda.time.Period;

@Entity
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@Setter
@Getter
public class User extends IdEntity implements UserDetails, Serializable {

    private String firstName;
    private String lastName;
    @Column(unique = true)
    @NonNull
    private String username;
    @NonNull
    private String password;
    private String email;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private Period automaticLogoutPeriod;
    @ElementCollection(targetClass = Role.class, fetch = EAGER)
    @Enumerated(STRING)
    private Set<Role> userRoles = EnumSet.noneOf(Role.class);
    @ManyToMany(mappedBy = "users", fetch = EAGER)
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new LinkedHashSet<>();
        for (Role role : getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.name()));
        }
        return grantedAuthorities;
    }
}
