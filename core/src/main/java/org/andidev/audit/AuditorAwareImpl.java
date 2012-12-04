package org.andidev.audit;

import org.andidev.system.domain.User;
import org.andidev.system.repository.UserRepository;
import org.andidev.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

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
