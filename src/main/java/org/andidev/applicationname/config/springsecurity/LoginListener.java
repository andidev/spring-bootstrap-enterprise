package org.andidev.applicationname.config.springsecurity;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.config.logging.MDC;
import org.andidev.applicationname.entity.User;
import static org.andidev.applicationname.util.ApplicationUtils.getSession;
import static org.andidev.applicationname.util.ApplicationUtils.getUser;
import static org.andidev.applicationname.util.ApplicationUtils.getUsername;
import static org.andidev.applicationname.util.TimeUtils.format;
import org.joda.time.Period;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.web.authentication.switchuser.AuthenticationSwitchUserEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginListener {

    @Component
    static class FormLoginAndRememberMeLoginListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

        @Inject
        LoginListener listener;

        @Override
        public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
            listener.onLogin(getUser());
        }
    }

    @Component
    static class SwitchUserLoginListener implements ApplicationListener<AuthenticationSwitchUserEvent> {

        @Inject
        LoginListener listener;

        @Override
        public void onApplicationEvent(AuthenticationSwitchUserEvent event) {
            listener.onLogin((User) event.getTargetUser());
        }
    }

    private void onLogin(User user) {
        MDC.putUsername(user.getUsername());
        setAutomaticLogoutTime(user.getAutomaticLogoutTime());
    }

    private void setAutomaticLogoutTime(Period automaticLogoutTime) {
        log.info("Setting automatic logout time to {}", format(automaticLogoutTime));
        int automaticLogoutTimeInSeconds = automaticLogoutTime.toStandardSeconds().getSeconds();
        getSession().setMaxInactiveInterval(automaticLogoutTimeInSeconds);
    }

}
