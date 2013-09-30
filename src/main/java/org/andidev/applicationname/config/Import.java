package org.andidev.applicationname.config;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.Opinion;
import org.andidev.applicationname.entity.User;
import org.andidev.applicationname.entity.enums.UserRole;
import org.andidev.applicationname.service.UserDetailsServiceImpl;
import org.andidev.applicationname.service.OpinionService;
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
        log.info("Creating Test Data: Users");
        User anonymousUser = new User("system","", UserRole.ROLE_SYSTEM);
        User adminUser = new User("admin","admin",  UserRole.ROLE_ADMIN);
        User user = new User("user", "user",  UserRole.ROLE_USER);
        userService.create(anonymousUser);
        userService.create(adminUser);
        userService.create(user);
        log.info("Done!");

        // Authenticate the user
        UserDetails userDetails = userDetailService.loadUserByUsername("system");
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

        log.info("Creating Test Data: Opinions");
        Opinion opinion = new Opinion("Test", "Lalala");
        Opinion opinion2 = new Opinion("Test", "Lalala");
        opinionService.create(opinion);
        opinionService.create(opinion2);
        log.info("Done!");
    }

}
