package org.andidev.applicationname.config.logging;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;
import static org.andidev.applicationname.util.ApplicationUtils.getUsername;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.filter.GenericFilterBean;

@Slf4j
public class MDCUsernameInsertingFilter extends GenericFilterBean implements InitializingBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MDC.putUsername(getUsername());
        chain.doFilter(request, response);
    }

}
