package org.andidev.applicationname.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ApplicationController extends AbstractApplicationController {
    
    @RequestMapping({"/"})
    public String root(Model model) {   
        return "redirect:/home";
    }

    @RequestMapping({"/home"})
    public String home(Model model) {
        return "pages/home";
    }

    @Secured({"ROLE_USER"})
    @RequestMapping({"/userhome"})
    public String userhome(Model model) {
        return "pages/userhome";
    }

    @Secured({"ROLE_USER"})
    @RequestMapping({"/user/settings"})
    public String settings(Model model) {
        return "pages/user/settings";
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping({"/system/groups"})
    public String groups(Model model) {
        return "pages/system/groups";
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping({"/system/users"})
    public String users(Model model) {
        return "pages/system/users";
    }

    @Secured({"ROLE_DEVELOPER"})
    @RequestMapping({"/system/javamelody"})
    public String javamelody(Model model) {
        return "pages/system/javamelody";
    }

    @Secured({"ROLE_DEVELOPER"})
    @RequestMapping({"/system/errors"})
    public String errors(Model model) {
        return "pages/system/errors";
    }
    
}
