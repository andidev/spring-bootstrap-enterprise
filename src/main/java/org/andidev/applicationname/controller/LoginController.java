package org.andidev.applicationname.controller;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.Opinion;
import org.andidev.applicationname.entity.enums.UserRole;
import org.andidev.applicationname.repository.OpinionRepository;
import org.andidev.applicationname.service.OpinionService;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
@Slf4j
public class LoginController extends AbstractApplicationController {

    @Inject
    private MessageSource messageSource;
    @Inject
    private OpinionService opinionService;
    @Inject
    private OpinionRepository opinionRepository;

    @RequestMapping("/")
    public String main(Model model,
            @RequestParam(required = false) String showLogin,
            @RequestParam(required = false) String message) {
        model.addAttribute("showLogin", showLogin);
        model.addAttribute("message", message);
        return "pages/main";
    }

    @RequestMapping("/admin")
    @Secured("ROLE_ADMIN")
    public String testing(Model model, @RequestParam(required = false) String message) {
        return "pages/admin";
    }

    @RequestMapping("/login")
    @Transactional
    public String login(Model model) {
        log.info("Testing!!!");
        Opinion opinion = new Opinion("Test", "Lalala");
        log.info(opinion.toString());
        opinionService.create(opinion);
        log.info(opinion.toString());
        log.info("count = " + opinionRepository.count());
        opinionRepository.findAll();
        log.info("count = " + opinionRepository.findAll().toString());
        String message = "Please Login!";
        return "redirect:/?showLogin=true&message=" + message;
    }

    @RequestMapping(value = "/login/success")
    public String loginSuccess() {
        String message = "Login Success!";
        return "redirect:/?message=" + message;
    }

    @RequestMapping(value = "/login/failure")
    public String loginFailure() {
        String message = "Login Failure!";
        return "redirect:/?showLogin=true&message=" + message;
    }

    @RequestMapping(value = "/logout/success")
    public String logoutSuccess() {
        String message = "Logout Success!";
        return "redirect:/?message=" + message;
    }

    @RequestMapping(value = "/accessdenied")
    public String accessDenied() {
        return "pages/accessdenied";
    }
}