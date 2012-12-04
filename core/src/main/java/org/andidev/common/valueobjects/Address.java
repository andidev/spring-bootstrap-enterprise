package org.andidev.common.valueobjects;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

/**
 * see http://techpolesen.blogspot.se/2007/11/10-tips-on-jpa-domain-modelling.html
 * 
 * @author anders
 */
@Data
@RequiredArgsConstructor
@Embeddable
public class Address implements Serializable {
   private String houseNumber;
   private String street;

   @Transient
   public String getHouseNumber() { return houseNumber; }

   @Transient
   public String getStreet() { return street; }

   @Basic
   public String getAddress() { return street + " " + houseNumber; }

   // setter needed by JPA, but protected as value object is immutable to domain
   protected void setAddress(String address) {
       // do all the parsing and rule enforcement here
   }
}
