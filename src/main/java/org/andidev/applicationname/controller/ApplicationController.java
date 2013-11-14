package org.andidev.applicationname.controller;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.andidev.applicationname.util.ApplicationUtils.*;
import static org.andidev.applicationname.entity.enums.Role.*;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
@Slf4j
public class ApplicationController {

    @RequestMapping({"/"})
    public String root(Model model) {
        return "redirect:/home";
    }

    @RequestMapping({"/home"})
    public String home(Model model, HttpServletRequest request) {
        if (hasRole(ROLE_USER)) {
            return "pages/userhome";
        } else {
            return "pages/home";
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping({"/user/settings"})
    public String settings(Model model) {
        return "pages/user/settings";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping({"/system/groups"})
    public String groups(Model model) {
        return "pages/system/groups";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping({"/system/users"})
    public String users(Model model) {
        return "pages/system/users";
    }

    @PreAuthorize("hasRole('ROLE_DEVELOPER')")
    @RequestMapping({"/system/javamelody"})
    public String javamelody(Model model) {
        return "pages/system/javamelody";
    }

    @PreAuthorize("hasRole('ROLE_DEVELOPER')")
    @RequestMapping({"/system/errors"})
    public String errors(Model model) {
        return "pages/system/errors";
    }

}
