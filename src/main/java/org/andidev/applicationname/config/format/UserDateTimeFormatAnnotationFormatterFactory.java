package org.andidev.applicationname.config.format;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static org.andidev.applicationname.util.ApplicationUtils.getUser;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.format.datetime.joda.DateTimeParser;
import org.springframework.format.datetime.joda.MillisecondInstantPrinter;
import org.springframework.format.datetime.joda.ReadableInstantPrinter;
import org.springframework.format.datetime.joda.ReadablePartialPrinter;

public class UserDateTimeFormatAnnotationFormatterFactory
        implements AnnotationFormatterFactory<UserDateTimeFormat> {

    private static final Set<Class<?>> FIELD_TYPES;

    static {
        Set<Class<?>> fieldTypes = new HashSet<>(7);
        fieldTypes.add(ReadableInstant.class);
        fieldTypes.add(LocalDate.class);
        fieldTypes.add(LocalTime.class);
        fieldTypes.add(LocalDateTime.class);
        fieldTypes.add(Date.class);
        fieldTypes.add(Calendar.class);
        fieldTypes.add(Long.class);
        FIELD_TYPES = Collections.unmodifiableSet(fieldTypes);
    }

    @Override
    public final Set<Class<?>> getFieldTypes() {
        return FIELD_TYPES;
    }

    @Override
    public Printer<?> getPrinter(UserDateTimeFormat annotation, Class<?> fieldType) {
        DateTimeFormatter formatter = getFormatter(annotation, fieldType);
        if (ReadablePartial.class.isAssignableFrom(fieldType)) {
            return new ReadablePartialPrinter(formatter);
        } else if (ReadableInstant.class.isAssignableFrom(fieldType) || Calendar.class.isAssignableFrom(fieldType)) {
            // assumes Calendar->ReadableInstant converter is registered
            return new ReadableInstantPrinter(formatter);
        } else {
            // assumes Date->Long converter is registered
            return new MillisecondInstantPrinter(formatter);
        }
    }

    @Override
    public Parser<DateTime> getParser(UserDateTimeFormat annotation, Class<?> fieldType) {
        return new DateTimeParser(getFormatter(annotation, fieldType));
    }

    protected DateTimeFormatter getFormatter(UserDateTimeFormat annotation, Class<?> fieldType) {
        UserDateTimeFormatterFactory factory = new UserDateTimeFormatterFactory();
        factory.setDateFormat(getUser().getDateFormat());
        factory.setTimeFormat(getUser().getTimeFormat());
        factory.setLocale(getUser().getLocale());
        factory.setTimeZone(getUser().getTimeZone());
        return factory.createDateTimeFormatter();
    }

}
