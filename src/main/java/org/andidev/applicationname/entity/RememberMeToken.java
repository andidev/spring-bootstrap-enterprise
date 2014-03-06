package org.andidev.applicationname.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import static lombok.AccessLevel.PROTECTED;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.andidev.applicationname.entity.abstracts.IdEntity;
import org.joda.time.DateTime;

@Entity
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RememberMeToken extends IdEntity {

    @NonNull
    @Column(length = 64)
    private String username;
    @Column(unique = true, length = 64)
    private String series;
    @NonNull
    @Column(length = 64)
    private String token;
    @NonNull
    private DateTime lastUsed;

}
