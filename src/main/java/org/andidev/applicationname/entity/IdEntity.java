package org.andidev.applicationname.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public class IdEntity extends  AbstractPersistable<Long> {

 }
