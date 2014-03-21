package org.andidev.applicationname.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    public static String parse(String url, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()) {
            try {
                return matcher.group(1);
            } catch (IndexOutOfBoundsException ex) {
                // Group is missing in regexp, create group around regex and try again
                return parse(url, "(" + regex + ")");
            }
        } else {
            return "";
        }
    }

}
