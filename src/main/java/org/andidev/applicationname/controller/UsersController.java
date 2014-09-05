package org.andidev.applicationname.controller;


import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.andidev.applicationname.service.JsonService;
import org.andidev.applicationname.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
@Slf4j
public class UsersController {

    @Inject
    private UserService userService;
    @Inject
    private JsonService jsonService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping({"/system/users"})
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "pages/system/users";
    }

}
