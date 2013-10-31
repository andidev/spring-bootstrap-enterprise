package org.andidev.applicationname.config.auditing;

import org.andidev.applicationname.util.ApplicationUtils;
import org.andidev.applicationname.entity.User;
import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<User> {

    @Override
    public User getCurrentAuditor() {

        return ApplicationUtils.getCurrentUser();
    }
}
