package org.andidev.logging.logback.old;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author anders
 *
 * see http://logback.qos.ch/manual/layouts.html#customConversionSpecifier
 */
public class ClassConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {

        return StringUtils.substringAfterLast(((StackTraceElement) event.getCallerData()[0]).getClassName(), ".");

    }
}
