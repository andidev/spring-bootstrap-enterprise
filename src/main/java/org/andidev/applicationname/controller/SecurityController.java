package org.andidev.applicationname.controller;

import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.andidev.applicationname.util.SecurityUtils.*;

@Controller
@RequestMapping
@Slf4j
public class SecurityController {

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

    @RequestMapping("/logout")
    public String logoutSwitchedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (isSwitchedUser()) {
            return "redirect:/switchuserlogout";
        }

        return "redirect:/normallogout";
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
    
    @RequestMapping("/switchuser")
    public String switchUser() {
        return "pages/switchuser";
    }
    
    @RequestMapping("/switchuserto{username}")
    public String switchUserUsername(@PathVariable String username) {
        return "redirect:/switchuserto?username=" + username;
    }
    
    @RequestMapping(value = "/accessdenied")
    public String accessDenied() {
        return "pages/accessdenied";
    }
}