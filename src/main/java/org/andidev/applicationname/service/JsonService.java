package org.andidev.applicationname.service;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.controller.AjaxController;
import org.andidev.applicationname.entity.User;
import org.andidev.applicationname.entity.enums.Role;
import org.andidev.applicationname.format.annotation.JsonFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class JsonService {

    @Inject
    UserService userService;
    private static Gson gson = new Gson();

    public List<Option> getUsers() {
        List users = new ArrayList();
        for (User user : userService.findAll()) {
            users.add(new JsonService.Option(user.getId().toString(), user.getUsername()));
        }
        return users;
    }

    @JsonFormat
    public List<Option> getRoles() {
        List roles = new ArrayList();
        for (Role role : Role.values()) {
            roles.add(new JsonService.Option(role.name(), role.toString()));
        }
        return roles;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Option {

        String id;
        String text;
    }
}
