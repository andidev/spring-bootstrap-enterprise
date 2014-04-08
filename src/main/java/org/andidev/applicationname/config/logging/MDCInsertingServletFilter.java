package org.andidev.applicationname.config.logging;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MDCInsertingServletFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        putDataInMDC(request);
        try {
            chain.doFilter(request, response);
        } finally {
            removeDataFromMDC();
        }
    }

    public static void putDataInMDC(ServletRequest request) {
        MDC.putSession(getSessionId(request));
        MDC.putUsername(getUsername(request));
    }

    public static void removeDataFromMDC() {
        MDC.removeSession();
        MDC.removeUsername();
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {
        // Do nothing
    }

    @Override
    public void destroy() {
        // Do nothing
    }

    public static String getSessionId(ServletRequest request) {
        if (!(request instanceof HttpServletRequest)) {
            return null;
        }

        HttpSession session =  ((HttpServletRequest) request).getSession();
        if (session == null) {
            return null;
        }
        return session.getId();
    }

    public static String getUsername(ServletRequest request) {
        if (!(request instanceof HttpServletRequest)) {
            return null;
        }

        return (String) ((HttpServletRequest) request).getAttribute("username");
    }

}
