package org.andidev.applicationname.audit;

import lombok.NoArgsConstructor;
import org.andidev.applicationname.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 *
 * @author anders
 *
 * @link http://stackoverflow.com/questions/360520/unit-testing-with-spring-security
 */
@NoArgsConstructor
public class UserHolder {

    public static User getUser() {

        // get user
        User user;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();

        // check instance type
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
        Object principal = auth.getPrincipal();

        // check instance type
        if (principal instanceof org.springframework.security.core.userdetails.User) {
            user = (org.springframework.security.core.userdetails.User) principal;
        } else {
            return null;
        }

        // check null
        if (user.getUsername() == null) {
            return null;
        }
    
        return user.getUsername();

    }

}