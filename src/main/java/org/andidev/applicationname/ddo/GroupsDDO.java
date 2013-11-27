package org.andidev.applicationname.ddo;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.andidev.applicationname.entity.enums.Role;

@Getter
@Setter
public class GroupsDDO {
    private List<Group> groups = new ArrayList<>();
    private boolean hideDisabledUsers = true;

    @Getter
    @Setter
    public static class Group {
        private String id;
        private String groupname;
        private List<User> users;
        private List<Role> roles;
    }

    @Getter
    @Setter
    public static class User {
        private String id;
        private String username;
    }
}
