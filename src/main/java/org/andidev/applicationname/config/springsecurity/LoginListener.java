package org.andidev.applicationname.config.springsecurity;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.User;
import org.andidev.applicationname.util.ApplicationUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    @Inject
    HttpSession session;
    
    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
        User user = ApplicationUtils.getCurrentUser();
        log.info("Setting the Automatic Logout Time for user {} to {} minutes", user.getUsername(), user.getAutomaticLogoutTime());
        session.setMaxInactiveInterval(user.getAutomaticLogoutTime()*60);        
    }
}