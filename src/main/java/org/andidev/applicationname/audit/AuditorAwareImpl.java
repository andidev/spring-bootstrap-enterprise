package org.andidev.applicationname.audit;

import org.andidev.applicationname.domain.User;
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
