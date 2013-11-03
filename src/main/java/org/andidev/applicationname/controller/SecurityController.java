package org.andidev.applicationname.controller;

import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@Slf4j
public class SecurityController extends AbstractApplicationController {

    public static final int MINUTES = 60;
    @Autowired
    private HttpSession session;
    
    @RequestMapping("/login")
    public String login() {
        return "pages/login";
    }

    @RequestMapping(value = "/login/success")
    public String loginSuccess() {
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