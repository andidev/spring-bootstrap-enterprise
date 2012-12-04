package org.andidev.logging.logback;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author anders
 * 
 * see
 * http://www.codelord.net/2010/08/27/logging-with-a-context-users-in-logback-and-spring-security/
 * http://logback.qos.ch/manual/layouts.html#customConversionSpecifier
 */
public class UserConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            return auth.getName();
        }
        return "NO_USER";
    }
}