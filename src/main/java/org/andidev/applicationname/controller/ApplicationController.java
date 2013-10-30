package org.andidev.applicationname.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.Opinion;
import org.andidev.applicationname.service.OpinionService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ApplicationController extends AbstractApplicationController {

    @Inject
    OpinionService opinionService;

    private void createOpinionTestData() {
        log.info("Creating opinions");
        Opinion opinion = new Opinion("Test", "Lalala");
        Opinion opinion2 = new Opinion("Test", "Lalala");
        opinionService.create(opinion);
        opinionService.create(opinion2);
    }

    @RequestMapping({"/"})
    public String root(Model model) {
        return "redirect:/home";
    }

    @RequestMapping({"/home"})
    public String home(Model model, HttpServletRequest request) {
        if (request.isUserInRole("ROLE_USER")) {
            createOpinionTestData();
            return "pages/userhome";
        } else {
            createOpinionTestData();
            return "pages/home";
        }
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
