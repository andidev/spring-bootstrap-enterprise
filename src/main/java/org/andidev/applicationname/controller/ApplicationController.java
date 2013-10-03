package org.andidev.applicationname.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
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

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping({"/userhome"})
    public String userhome(Model model) {
        return "pages/userhome";
    }
}
