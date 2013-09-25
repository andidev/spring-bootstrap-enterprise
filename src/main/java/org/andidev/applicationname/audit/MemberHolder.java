package org.andidev.applicationname.audit;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author anders
 *
 * @link http://www.javafreedom.org/?p=414
 * @link http://stackoverflow.com/questions/360520/unit-testing-with-spring-security
 */
public class MemberHolder {

    private MemberHolder() {
        // hidden default constructor, this is a "normal" utility class
    }

    public static String getMember() {
        /*
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        Member member;

        if (principal instanceof Member) {
            member = (Member) principal;
        } else {
            return null;
        }

        if (member.getId() == null) {
            return null;
        }
        return member;
        */
        return "admin";
    }
}