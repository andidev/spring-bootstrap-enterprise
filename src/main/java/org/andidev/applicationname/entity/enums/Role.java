package org.andidev.applicationname.entity.enums;

import java.util.EnumSet;
import java.util.Set;

public enum Role {

    ROLE_ROOT,
    ROLE_DEVELOPER,
    ROLE_ADMIN,
    ROLE_USER,
    ROLE_ANONYMOUS;

    public static Set<Role> getAllRolesExceptAnonymous() {
        Set set = EnumSet.allOf(Role.class);
        set.remove(ROLE_ANONYMOUS);
        return set;
    }

}
