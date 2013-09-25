package org.andidev.applicationname.entity;

import java.io.Serializable;
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
public class CompanyPreference implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PROTECTED) 
    private Long id;
    @ManyToOne
    private Company company;
    @ManyToOne
    private Preference preference;
    private String value;
}
