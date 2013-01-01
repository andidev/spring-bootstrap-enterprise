/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.andidev.common.entity;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author anders
 */
@Data
@MappedSuperclass
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PROTECTED)
    private Long id;
    @Version
    @Setter(AccessLevel.PROTECTED)
    private Long version;
    
    public String toPrettyString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
