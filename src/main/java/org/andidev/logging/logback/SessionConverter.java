package org.andidev.logging.logback;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 *
 * @author anders
 * 
 * see
 * http://www.codelord.net/2010/08/27/logging-with-a-context-users-in-logback-and-spring-security/
 * http://logback.qos.ch/manual/layouts.html#customConversionSpecifier
 */
public class SessionConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
        if (attrs != null) {
            return attrs.getSessionId();
        }
        return "NO_SESSION";
    }
}
