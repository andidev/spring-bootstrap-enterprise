package org.andidev.logging.logback.old;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.andidev.logging.logback.colors.BashColor;
import org.joda.time.LocalTime;

/**
 *
 * @author anders
 * 
 * see http://logback.qos.ch/manual/layouts.html#customConversionSpecifier
 */
public class TimeColorConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(getColor(event.getLevel()));
        stringBuilder.append(new LocalTime(event.getTimeStamp()).toString("HH:mm ss"));
        stringBuilder.append(BashColor.COLOR_OFF);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /**
     * Returns the appropriate characters to change the color for the specified
     * logging level.
     */
    private String getColor(Level level) {
        //return LevelEncoder.getColor(level);
        return BashColor.PURPLE;
    }
}
