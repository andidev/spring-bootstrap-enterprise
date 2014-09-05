package org.andidev.applicationname.controller;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.TimeZone;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.andidev.applicationname.entity.enums.Role.*;
import org.andidev.applicationname.service.JsonService;
import org.andidev.applicationname.service.GroupService;
import org.andidev.applicationname.service.UserService;
import static org.andidev.applicationname.util.SecurityUtils.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.datetime.joda.JodaTimeContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
@Slf4j
public class ApplicationController {

    @Value("${database.url}")
    private String databaseUrl;
    @Value("${database.driver}")
    private String databaseDriver;
    @Value("${database.username}")
    private String databaseUsername;
    @Value("${database.password}")
    private String databasePassword;

    @Inject
    private GroupService groupService;
    @Inject
    private UserService userService;
    @Inject
    private JsonService jsonService;

    @RequestMapping({"/"})
    public String root(Model model) {
        return "redirect:/home";
    }

    @RequestMapping({"/home"})
    public String home(Model model, HttpServletRequest request) {
        if (hasRole(ROLE_USER)) {
            return "pages/userhome";
        } else {
            return "pages/home";
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping({"/user/settings"})
    public String settings(Model model) {
        model.addAttribute("test", new Test());
        return "pages/user/settings";
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @RequestMapping({"/system/groups"})
//    public String groups(Model model) {
//        List<Group> groups = groupService.findAll();
//        model.addAttribute("groups", new Groups(groups));
//        model.addAttribute("roles", jsonService.getRoles());
//
//        model.addAttribute("roles", jsonService.getRoles());
//        model.addAttribute("roles", jsonService.getRoles());
//        return "pages/system/groups";
//    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @RequestMapping({"/system/users"})
//    public String users(Model model) {
//        model.addAttribute("users", userService.findAll());
//        return "pages/system/users";
//    }

    @PreAuthorize("hasRole('ROLE_DEVELOPER') and !isProductionEnvironment()")
    @RequestMapping({"/system/database"})
    public String database(Model model) {
        model.addAttribute("databaseUrl", databaseUrl);
        model.addAttribute("databaseDriver", databaseDriver);
        model.addAttribute("databaseUsername", databaseUsername);
        model.addAttribute("databasePassword", databasePassword);
        return "pages/system/database";
    }

    @PreAuthorize("hasRole('ROLE_DEVELOPER')")
    @RequestMapping({"/system/javamelody"})
    public String javamelody(Model model) {
        return "pages/system/javamelody";
    }

    @PreAuthorize("hasRole('ROLE_DEVELOPER')")
    @RequestMapping({"/system/errors"})
    public String errors(Model model) {
        return "pages/system/errors";
    }

    @Getter
    @Setter
    public class Test {

        private Locale jvmLocale = Locale.getDefault();
        private Locale locale = LocaleContextHolder.getLocale();
        private String jvmTimeZone = TimeZone.getDefault().getID();
        private DateTimeZone jodaTimeTimeZone = DateTimeZone.getDefault();
        private DateTimeZone timeZone = JodaTimeContextHolder.getJodaTimeContext().getTimeZone();
        @DateTimeFormat(style = "S-")
        private DateTime currentDate = DateTime.now();
        @DateTimeFormat(style = "-S")
        private DateTime currentTime = DateTime.now();
//        @DateTimeFormat(style = "SS")
        private DateTime currentDateTime = DateTime.now();
        @NumberFormat(style = NumberFormat.Style.CURRENCY)
        private BigDecimal currency = new BigDecimal(99.99);
        @NumberFormat(style = NumberFormat.Style.NUMBER)
        private BigDecimal number = new BigDecimal(99.99);
        @NumberFormat(style = NumberFormat.Style.PERCENT)
        private BigDecimal percent = new BigDecimal(0.90);
    }
}
