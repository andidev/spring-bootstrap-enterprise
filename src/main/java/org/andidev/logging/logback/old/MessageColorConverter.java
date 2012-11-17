package org.andidev.logging.logback.old;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.andidev.logging.logback.colors.BashColor;

/**
 *
 * @author anders
 * 
 * see http://logback.qos.ch/manual/layouts.html#customConversionSpecifier
 */
public class MessageColorConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getColor(event.getLevel()));
        stringBuilder.append(event.getMessage());
        stringBuilder.append(BashColor.COLOR_OFF);
        return stringBuilder.toString();
    }

    /**
     * Returns the appropriate characters to change the color for the specified
     * logging level.
     */
    private String getColor(Level level) {
        return LevelColorConverter.getColor(level);
        //return BashColor.BLUE;
    }
}
