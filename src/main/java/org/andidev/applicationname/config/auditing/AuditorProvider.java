package org.andidev.applicationname.config.auditing;

import org.andidev.applicationname.entity.User;
import org.springframework.data.domain.AuditorAware;
import static org.andidev.applicationname.util.ApplicationUtils.getUser;

public class AuditorProvider implements AuditorAware<User> {

    @Override
    public User getCurrentAuditor() {
        return getUser();
    }
}
