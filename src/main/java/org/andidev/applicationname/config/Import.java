package org.andidev.applicationname.config;

import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.Opinion;
import org.andidev.applicationname.entity.User;
import org.andidev.applicationname.entity.enums.Role;
import org.andidev.applicationname.service.OpinionService;
import org.andidev.applicationname.service.UserDetailsServiceImpl;
import org.andidev.applicationname.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Import {

    @Inject
    UserService userService;
    @Inject
    OpinionService opinionService;
    @Inject
    UserDetailsServiceImpl userDetailService;

    @PostConstruct
    public void importData() {
        log.info("Creating initial database data");
        log.info("Creating Users");

        log.info("Creating root user");
        User systemUser = new User("root", "");
        systemUser.getUserRoles().addAll(Arrays.asList(Role.values()));
        userService.create(systemUser);

        log.info("Creating developer user");
        User developerUser = new User("developer", "");
        developerUser.getUserRoles().add(Role.ROLE_DEVELOPER);
        developerUser.getUserRoles().add(Role.ROLE_ADMIN);
        developerUser.getUserRoles().add(Role.ROLE_USER);
        userService.create(developerUser);

        log.info("Creating admin user");
        User adminUser = new User("admin", "");
        adminUser.getUserRoles().add(Role.ROLE_ADMIN);
        adminUser.getUserRoles().add(Role.ROLE_USER);
        userService.create(adminUser);

        log.info("Creating user");
        User user = new User("user", "");
        adminUser.getUserRoles().add(Role.ROLE_USER);
        userService.create(user);

        log.info("Initial database data created!");

        // Authenticate the user
        UserDetails userDetails = userDetailService.loadUserByUsername("root");
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);



        log.info("Creating test data");

        log.info("Creating opinions");
        Opinion opinion = new Opinion("Test", "Lalala");
        Opinion opinion2 = new Opinion("Test", "Lalala");
        opinionService.create(opinion);
        opinionService.create(opinion2);

        log.info("Test data created!");
    }
}
