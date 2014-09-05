package org.andidev.applicationname.controller;

import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.User;
import org.andidev.applicationname.entity.enums.Role;
import org.andidev.applicationname.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping({"/ajax"})
public class AjaxController {

    @Inject
    UserService userService;

    @RequestMapping({"/users"})
    public @ResponseBody
    Collection users() {
        Collection users = new ArrayList();
        for (User user : userService.findAll()) {
            users.add(new Option(user.getId().toString(), user.getUsername()));
        }
        return users;
    }

    @RequestMapping({"/roles"})
    public @ResponseBody
    Collection roles() {
        Collection roles = new ArrayList();
        for (Role role : Role.values()) {
            roles.add(new Option(role.name(), role.toString()));
        }
        return roles;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public class Option {
        String id;
        String text;
    }
}
