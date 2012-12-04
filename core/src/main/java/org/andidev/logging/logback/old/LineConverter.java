package org.andidev.logging.logback.old;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 *
 * @author anders
 *
 * see http://logback.qos.ch/manual/layouts.html#customConversionSpecifier
 */
public class LineConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {

        return Integer.toString(((StackTraceElement) event.getCallerData()[0]).getLineNumber());

    }
}
