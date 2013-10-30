package org.andidev.applicationname.config.auditing;

import org.andidev.applicationname.util.ApplicationUtils;
import org.andidev.applicationname.entity.User;
import org.springframework.data.domain.AuditorAware;

/**
 *
 * @author anders
 */
public class AuditorAwareImpl implements AuditorAware<User> {

    @Override
    public User getCurrentAuditor() {

        return ApplicationUtils.getCurrentUser();
    }
}
