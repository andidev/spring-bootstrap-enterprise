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

    public static String parenthesize(Object object) {
        return parenthesize(nullSafeToString(object));
    }    
}
