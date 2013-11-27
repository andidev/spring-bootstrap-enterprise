package org.andidev.applicationname.config.format;

import java.util.Locale;
import lombok.Setter;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class UserDateTimeFormatterFactory {

    @Setter
    private String dateFormat;

    @Setter
    private String timeFormat;

    @Setter
    private DateTimeZone timeZone;

    @Setter
    private Locale locale;

    public DateTimeFormatter createDateTimeFormatter() {
        DateTimeFormatter formatter;
        if (dateFormat != null && timeFormat != null) {
            formatter = DateTimeFormat.forStyle(dateFormat + " " + timeFormat);
        } else {
            formatter = DateTimeFormat.mediumDateTime();
        }

        if (timeZone != null) {
            formatter = formatter.withZone(timeZone);
        }

        if (locale != null) {
            formatter = formatter.withLocale(locale);
        }
        return formatter;
    }

}
