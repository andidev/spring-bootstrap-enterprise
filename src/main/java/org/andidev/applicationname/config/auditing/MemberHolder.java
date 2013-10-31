package org.andidev.applicationname.config.auditing;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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