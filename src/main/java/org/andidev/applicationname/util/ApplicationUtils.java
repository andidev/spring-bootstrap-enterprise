package org.andidev.applicationname.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.andidev.applicationname.entity.User;
import org.andidev.applicationname.entity.enums.Role;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ApplicationUtils {

    public static User getUser() {
        // Check authentication exists
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }

        // Get user
        Object principal = authentication.getPrincipal();
        if (principal instanceof User) {
            return (User) principal;
        }

        throw new RuntimeException("Unable to get user. Unknown user type found in SecurityContextHolder's principal = " + ReflectionToStringBuilder.toString(principal));
    }

    public static String getUsername() {
        User user = getUser();
        if (user == null) {
            return null;
        }

        return user.getUsername();
    }

    public static boolean hasRole(String role) {
        return getRequest().isUserInRole(role);
    }

    public static boolean hasRole(Role role) {
        return getRequest().isUserInRole(role.name());
    }

    public static boolean isSwitchedUser() {
        return hasRole("ROLE_PREVIOUS_ADMINISTRATOR");
    }

    public static boolean isAuthenticatedUser() {
        // Check authentication exists
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }

        return !AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass());
    }

    public static boolean isUnAuthenticatedUser() {
        return !isAuthenticatedUser();
    }

    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return request;
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static String getSessionId() {
        RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
        if (attrs == null) {
            return null;
        }

        return attrs.getSessionId();
    }

    public static void login(String username, String password) throws ServletException {
        getRequest().login(username, password);
    }

    public static void logout() throws ServletException {
        getRequest().logout();
    }

}
