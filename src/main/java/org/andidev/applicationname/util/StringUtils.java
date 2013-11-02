package org.andidev.applicationname.util;

public class StringUtils {

    public static String nullSafeToString(Object object) {
        if (object == null) {
            return null;
        }
        return object.toString();
    }

    public static String parenthesize(String text) {
        return "(" + text + ")";
    }
}
