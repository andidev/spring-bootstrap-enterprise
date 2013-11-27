package org.andidev.applicationname.ddo;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.andidev.applicationname.entity.enums.Role;

@Getter
@Setter
public class UsersDDO {
    private List<User> users = new ArrayList<>();
    private boolean hideDisabledUsers = true;

    @Getter
    @Setter
    public static class User {
        private String id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private boolean accountNonExpired;
        private boolean accountNonLocked;
        private boolean credentialsNonExpired;
        private boolean enabled;
        private List<Group> groups;
        private List<Role> roles;
    }

    @Getter
    @Setter
    public static class Group {
        private String id;
        private String groupname;
    }
}