package org.andidev.logging.logback.old;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.joda.time.LocalTime;

/**
 *
 * @author anders
 * 
 * see http://logback.qos.ch/manual/layouts.html#customConversionSpecifier
 */
public class TimeConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        return new LocalTime(event.getTimeStamp()).toString("HH:mm ss");
    }
}
