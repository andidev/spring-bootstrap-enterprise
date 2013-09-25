package org.andidev.applicationname.config.audit;

import org.andidev.applicationname.entity.User;
import org.springframework.data.domain.AuditorAware;

/**
 *
 * @author anders
 */
public class AuditorAwareImpl implements AuditorAware<User> {

    @Override
    public User getCurrentAuditor() {

        return UserHolder.getUser();
    }
}
