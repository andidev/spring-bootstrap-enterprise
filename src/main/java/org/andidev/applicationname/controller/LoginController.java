package org.andidev.applicationname.controller;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.controller.AbstractApplicationController;
import org.andidev.applicationname.entity.Opinion;
import org.andidev.applicationname.repository.OpinionRepository;
import org.andidev.applicationname.service.OpinionService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
@Slf4j
public class LoginController extends AbstractApplicationController  {
    
    @Inject
    OpinionService opinionService;
    @Inject
    OpinionRepository opinionRepository;
    
    @RequestMapping("/login")
    @Transactional
    public String login(Model model, @RequestParam(required = false) String message) {
        log.info("Testing!!!");
        Opinion opinion = new Opinion("Test", "Lalala");
        log.info(opinion.toString());
        opinionService.create(opinion);
        log.info(opinion.toString());
        log.info("count = " + opinionRepository.count());
        opinionRepository.findAll();
        log.info("count = " + opinionRepository.findAll().toString());
        
        model.addAttribute("message", message);
        return "login/login";
    }

    @RequestMapping(value = "/denied")
    public String denied() {
        return "login/denied";
    }

    @RequestMapping(value = "/login/failure")
    public String loginFailure() {
        String message = "Login Failure!";
        return "redirect:/login?message=" + message;
    }

    @RequestMapping(value = "/logout/success")
    public String logoutSuccess() {
        String message = "Logout Success!";
        return "redirect:/login?message=" + message;
    }
}