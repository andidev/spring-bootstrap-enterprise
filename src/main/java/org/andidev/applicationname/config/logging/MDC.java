package org.andidev.applicationname.config.logging;

import static org.apache.commons.lang3.StringUtils.left;

public class MDC {

    public static void putSession(String session) {
        org.slf4j.MDC.put("session", left(session, 9));
    }

    public static void removeSession() {
        org.slf4j.MDC.remove("session");
    }

    public static void putUsername(String username) {
        org.slf4j.MDC.put("username", username);
    }

    public static void removeUsername() {
        org.slf4j.MDC.remove("username");
    }
}
