package org.andidev.applicationname.config.springsecurity;

import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.config.logging.MDC;
import static org.andidev.applicationname.util.StringUtils.quote;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogoutListener implements ApplicationListener<SessionDestroyedEvent> {

    @Override
    public void onApplicationEvent(SessionDestroyedEvent event) {
        String sessionId = (String) ((HttpSessionDestroyedEvent) event).getSession().getId();
        String username = (String) ((HttpSessionDestroyedEvent) event).getSession().getAttribute("username");
        MDC.putSession(sessionId);
        MDC.putUsername(username);
        log.info("Logged out as {}", quote(username));
        MDC.removeSession();
        MDC.removeUsername();
    }
}
