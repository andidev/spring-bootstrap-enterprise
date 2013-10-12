package org.andidev.applicationname.entity;

import org.andidev.applicationname.entity.enums.Role;
import java.io.Serializable;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author anders
 */
@Entity
//@Table(schema="system")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Setter(AccessLevel.PROTECTED)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    @NonNull
    private String username;
    @NonNull
    private String password;
    private String email;
    @ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    private Set<Role> userRoles = EnumSet.noneOf(Role.class);
    @ManyToMany(mappedBy = "users")
    private Set<Group> groups;

    @OneToMany(mappedBy = "user")
    private Set<PreferenceValue> preferences = new HashSet();
}
