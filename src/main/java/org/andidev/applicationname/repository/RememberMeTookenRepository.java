package org.andidev.applicationname.repository;

import java.util.List;
import org.andidev.applicationname.entity.RememberMeToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RememberMeTookenRepository extends JpaRepository<RememberMeToken, Long> {

    RememberMeToken findBySeries(String series);

    List<RememberMeToken> findByUsername(String username);

}
