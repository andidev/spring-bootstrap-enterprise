package org.andidev.applicationname.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.User;
import org.andidev.applicationname.entity.enums.Role;
import org.andidev.applicationname.format.annotation.JsonFormat;
import org.andidev.applicationname.format.annotation.ListFormat;
import org.andidev.applicationname.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.andidev.applicationname.service.JsonService;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
@Slf4j
public class GroupsController {

    @Inject
    private GroupService groupService;
    @Inject
    private JsonService jsonService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping({"/system/groups"})
    public String groups(Model model) {
        GroupsController.ViewModel viewModel = new GroupsController.ViewModel();
        viewModel.setGroups(convertGroups(groupService.findAll()));
        viewModel.setUsers(jsonService.getUsers());
        viewModel.setRoles(jsonService.getRoles());

        model.addAttribute("viewModel", viewModel);
        return "pages/system/groups";
    }

    private List<GroupsController.Group> convertGroups(List<org.andidev.applicationname.entity.Group> groupsToConvert) {
        List<GroupsController.Group> groups = new ArrayList<>();
        for (org.andidev.applicationname.entity.Group group : groupsToConvert) {
            List<Long> userIds = new ArrayList<>();
            List<String> userNames = new ArrayList<>();
            for (User user : group.getUsers()) {
                userIds.add(user.getId());
                userNames.add(user.getUsername());
            }
            groups.add(new GroupsController.Group(group.getId(), group.getGroupname(), group.getGroupRoles(), userIds, userNames));
        }
        return groups;
    }

    @Getter
    @Setter
    public static class ViewModel {

        private Collection<GroupsController.Group> groups;
        @JsonFormat
        private Collection<JsonService.Option> roles;
        @JsonFormat
        private Collection<JsonService.Option> users;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Group {

        private Long id;
        private String groupname;
        @ListFormat
        private Collection<Role> roles;
        private Collection<Long> userIds;
        @ListFormat
        private Collection<String> userNames;
    }
}
