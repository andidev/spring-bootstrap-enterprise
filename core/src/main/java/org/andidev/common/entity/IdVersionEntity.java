/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.andidev.common.entity;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 *
 * @author anders
 */
@Data
@MappedSuperclass
public class IdVersionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PROTECTED)
    private Long id;
    @Version
    @Setter(AccessLevel.PROTECTED)
    private Long version;
}
