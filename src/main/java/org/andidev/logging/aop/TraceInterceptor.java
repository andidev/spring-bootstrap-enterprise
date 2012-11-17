package org.andidev.logging.aop;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;

/**
 * Extends {@link CustomizableTraceInterceptor} to provide custom logging levels
 */
@Slf4j
public class TraceInterceptor extends CustomizableTraceInterceptor {

    private static final long serialVersionUID = 287162721460370957L;
    
    @Override
    protected void writeToLog(Log logger, String message, Throwable ex) {
        if (ex != null) {
            log.debug(message, ex);
        } else {
            log.debug(message);
        }
    }

    @Override
    protected boolean isInterceptorEnabled(MethodInvocation invocation, Log logger) {
        return true;
    }
}