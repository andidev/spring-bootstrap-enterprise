package org.andidev.logging.logback.colors;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 *
 * @author anders
 *
 * see http://logback.qos.ch/manual/layouts.html#customConversionSpecifier
 */
public class ColorLevelConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {

        return getColor(event.getLevel());

    }

    /**
     * Returns the appropriate characters to change the color for the specified
     * logging level.
     */
    static public String getColor(Level level) {

        switch (level.toInt()) {
            case Level.ERROR_INT:
                return BashColor.RED_BOLD;
            case Level.WARN_INT:
                return BashColor.RED;
            case Level.INFO_INT:
                return BashColor.BLUE;
            default:
                return BashColor.COLOR_OFF;
        }

    }
}
