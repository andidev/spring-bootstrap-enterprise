package org.andidev.applicationname.config.logging;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.andidev.applicationname.util.ApplicationUtils;
import org.slf4j.MDC;

public class MDCInsertingServletFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        putUsernameAndSessionInMDC();
        try {
            chain.doFilter(request, response);
        } finally {
            removeUsernameAndSessionFromMDC();
        }
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {
        // Do nothing
    }

    @Override
    public void destroy() {
        // Do nothing
    }

    public static void putUsernameAndSessionInMDC() {
        MDC.put("username", getUsername());
        MDC.put("session", getSessionId());
    }

    public static void removeUsernameAndSessionFromMDC() {
        MDC.remove("username");
        MDC.remove("session");
    }

    private static String getUsername() {
        String username = ApplicationUtils.getCurrentUsername();
        if (username == null) {
            return "noUser";
        }

        return username;
    }

    private static String getSessionId() {
        String sessionId = ApplicationUtils.getCurrentSessionId();
        if (sessionId != null) {
            return "noSession";
        }

        return sessionId;
    }
}
