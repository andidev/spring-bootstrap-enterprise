package org.andidev.applicationname.util;

import org.andidev.applicationname.entity.User;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class ApplicationUtils {

    public static User getCurrentUser() {
        User user;

        // check authentication exists
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }

        // get user
        Object principal = authentication.getPrincipal();
        if (principal instanceof User) {
            return (User) principal;
        }

        throw new RuntimeException("Unknown user type found in SecurityContextHolder, principal = " + ReflectionToStringBuilder.toString(principal));
    }

    public static String getCurrentUsername() {

        User user = getCurrentUser();
        if (user == null) {
            return null;
        }

        return user.getUsername();
    }

    private static String getCurrentSessionId() {
        RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
        if (attrs == null) {
            return null;
        }

        return attrs.getSessionId();
    }
}