package org.andidev.system.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author anders
 */
@Entity
//@Table(schema="system")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PROTECTED)
    private Long id;
    private String name;
    @Column(unique = true)
    private String companyname; // used with User.username and User.password to login user
    @ManyToOne
    private System system;
    @OneToMany(mappedBy = "company")
    private Set<User> users = new HashSet();
    @OneToMany(mappedBy = "company")
    private Set<CompanyPreference> preferences = new HashSet();
}
