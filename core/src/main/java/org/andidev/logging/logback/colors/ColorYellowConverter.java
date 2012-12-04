package org.andidev.logging.logback.colors;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 *
 * @author anders
 *
 * see http://logback.qos.ch/manual/layouts.html#customConversionSpecifier
 */
public class ColorYellowConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {

        return BashColor.YELLOW;

    }
}
