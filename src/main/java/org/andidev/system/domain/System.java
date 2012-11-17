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
public class System implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PROTECTED)
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "system")
    private Set<Company> companies = new HashSet();
    @OneToMany(mappedBy = "system")
    private Set<SystemPreference> preferences = new HashSet();
}
