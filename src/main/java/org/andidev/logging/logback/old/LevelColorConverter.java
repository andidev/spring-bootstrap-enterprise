package org.andidev.logging.logback.old;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.andidev.logging.logback.colors.BashColor;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author anders
 * 
 * see http://logback.qos.ch/manual/layouts.html#customConversionSpecifier
 */
public class LevelColorConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getColor(event.getLevel()));
        stringBuilder.append(StringUtils.rightPad(event.getLevel().toString(), 5));
        stringBuilder.append(BashColor.COLOR_OFF);
        return stringBuilder.toString();
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
                return "";
        }
    }
}
