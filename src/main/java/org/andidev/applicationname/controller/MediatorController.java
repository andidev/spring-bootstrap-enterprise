package org.andidev.applicationname.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.controller.AbstractApplicationController;
import org.andidev.applicationname.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class MediatorController extends AbstractApplicationController {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    //
    // usage validator.validate(person)
    @Inject
    UserService userService;
    //@Inject
    //OpinionRepository opinionRepository;

//    @RequestMapping(value = "/")
//    public String getHomePage(ModelMap model) throws Exception {
//        String menu = getDefaultMenu();
//        String subMenu = getDefaultSideMenu(menu);
//        String title = getTitle(menu, subMenu);
//        String username = getUsername();
//
//        model.addAttribute("menu", menu);
//        model.addAttribute("subMenu", subMenu);
//        model.addAttribute("title", title);
//        model.addAttribute("username", username);
////
//        return "application/application";
//    }
//
//    @RequestMapping(value = "/{menu}")
//    public String getMenuPage(@PathVariable String menu, ModelMap model) throws Exception {
//        String subMenu = getDefaultSideMenu(menu);
//        String title = getTitle(menu, subMenu);
//        String username = getUsername();
//
//        //model.addAttribute("menu", menu);
//        model.addAttribute("subMenu", subMenu);
//        model.addAttribute("title", title);
//        model.addAttribute("username", username);
//        return "application/application";
//    }
//
//    @RequestMapping(value = "/{menu}/{subMenu}")
//    public String getSideMenuPage(@PathVariable String menu, @PathVariable String subMenu, ModelMap model) throws Exception {
//        String title = getTitle(menu, subMenu);
//        String username = getUsername();
//
//        //model.addAttribute("menu", menu);
//        //model.addAttribute("subMenu", subMenu);
//        model.addAttribute("title", title);
//        model.addAttribute("username", username);
//        return "application/application";
//    }
//
//    @RequestMapping("/env")
//    public void env(HttpServletResponse response) throws IOException {
//        response.setContentType("text/plain");
//        PrintWriter out = response.getWriter();
//        out.println("System Environment:");
//        for (Map.Entry<String, String> envvar : System.getenv().entrySet()) {
//            out.println(envvar.getKey() + ": " + envvar.getValue());
//        }
//    }
//
//    private String getDefaultMenu() {
//        return "home";
//    }
//
//    private String getDefaultSideMenu(String menu) throws Exception {
//
//        if ("admin".equals(menu)) {
//            return "overview";
//        }
//
//        if ("development".equals(menu)) {
//            return "overview";
//        }
//
//        if ("home".equals(menu)) {
//            return "overview";
//        }
//
//        if ("invoice".equals(menu)) {
//            return "search";
//        }
//
//        if ("shipment".equals(menu)) {
//            return "search";
//        }
//
//        if ("price-list".equals(menu)) {
//            return "search";
//        }
//
//        throw new Exception("Default Sub Menu is not setup in MediatorController for menu = " + menu);
//
//    }
//
//    private String getTitle(String menu, String subMenu) {
//        return menu + " | " + subMenu;
//    }
//
//    private String getUsername() {
//        return SecurityContextHolder.getContext().getAuthentication().getName();
//    }
}
