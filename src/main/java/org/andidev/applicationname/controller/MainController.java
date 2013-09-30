package org.andidev.applicationname.controller;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.repository.OpinionRepository;
import org.andidev.applicationname.service.OpinionService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
@Slf4j
public class MainController {
    
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

}
