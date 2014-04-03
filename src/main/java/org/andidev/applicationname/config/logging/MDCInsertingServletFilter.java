package org.andidev.applicationname.config.logging;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import static org.andidev.applicationname.util.ApplicationUtils.*;

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
        MDC.putSession(getSessionId());
        MDC.putUsername(getUsername());
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

}
