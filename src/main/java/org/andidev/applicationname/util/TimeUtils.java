package org.andidev.applicationname.util;

import org.joda.time.Period;
import org.joda.time.format.PeriodFormat;

public class TimeUtils {

    public static String formatMilliseconds(long milliSeconds) {
        return format(new Period(milliSeconds));
    }

    public static String format(Period milliSeconds) {
        return PeriodFormat.getDefault().print(milliSeconds);
    }

}
