package org.andidev.applicationname.config.audit;

import lombok.NoArgsConstructor;
import org.andidev.applicationname.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@NoArgsConstructor
public class UserHolder {

    public static User getUser() {

        // get user
        User user;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }

        // check instance type
        Object principal = auth.getPrincipal();
        if (principal instanceof User) {
            user = (User) principal;
        } else {
            return null;
        }

        // check null
        if (user.getId() == null) {
            return null;
        }

        return user;

    }

    public static String getUsername() {

        // get user
        org.springframework.security.core.userdetails.User user;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return "noUser";
        }

        // check instance type
        Object principal = auth.getPrincipal();
        if (principal instanceof org.springframework.security.core.userdetails.User) {
            user = (org.springframework.security.core.userdetails.User) principal;

            // check null
            if (user.getUsername() == null) {
                return "noUser";
            }

            return user.getUsername();

        } else if (principal instanceof String) {
            return (String) principal;
        }
        
        return null;

    }
}