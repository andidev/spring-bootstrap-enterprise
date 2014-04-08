package org.andidev.applicationname.config.logging;

import static java.lang.System.currentTimeMillis;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import static org.andidev.applicationname.util.TimeUtils.formatMilliseconds;
import static org.apache.commons.lang3.StringUtils.startsWith;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Slf4j
public class ExecutionTimeInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        long startTime = currentTimeMillis();
        request.setAttribute("startTime", startTime);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (isRedirect(modelAndView)) {
            // Skip calulation of execution time if the view is redirected to another url
            return;
        }

        // Calculate execution time
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = currentTimeMillis();
        String executionTime = formatMilliseconds(endTime - startTime);

        // Add execution time to model
        modelAndView.addObject("executionTime", executionTime);

        if (log.isTraceEnabled()) {
            log.trace("executionTime = {}", executionTime);
        }
    }

    private boolean isRedirect(ModelAndView modelAndView) {
        return startsWith(modelAndView.getViewName(), "redirect:");
    }

}
