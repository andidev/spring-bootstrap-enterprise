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
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PreferenceValue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PROTECTED)
    private Long id;
    @ManyToOne
    private Preference preference;
    private String value;
}
