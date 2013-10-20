package org.andidev.applicationname.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@Slf4j
public class SecurityController extends AbstractApplicationController {

    @RequestMapping("/login")
    @Transactional
    public String login(Model model) {
        return "pages/login";
    }

    @RequestMapping(value = "/login/success")
    public String loginSuccess(Model model) {
        return "redirect:/home";
    }

    @RequestMapping(value = "/login/failure")
    public String loginFailure(Model model) {
        String message = "Wrong password or username provided! Please try again.";
        model.addAttribute("message", message);
        return "pages/login";
    }

    @RequestMapping(value = "/logout/success")
    public String logoutSuccess() {
        return "redirect:/home";
    }

    @RequestMapping(value = "/accessdenied")
    public String accessDenied() {
        return "pages/accessdenied";
    }
}