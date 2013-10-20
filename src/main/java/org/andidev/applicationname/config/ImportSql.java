package org.andidev.applicationname.config;

import java.util.Arrays;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.Group;
import org.andidev.applicationname.entity.Opinion;
import org.andidev.applicationname.entity.User;
import org.andidev.applicationname.entity.enums.Role;
import org.andidev.applicationname.service.GroupService;
import org.andidev.applicationname.service.OpinionService;
import org.andidev.applicationname.service.UserDetailsServiceImpl;
import org.andidev.applicationname.service.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
public class ImportSql implements ApplicationListener<ContextRefreshedEvent> {
    
    @Inject
    private GroupService groupService;
    @Inject
    UserService userService;
    @Inject
    UserDetailsServiceImpl userDetailService;
    @Inject
    OpinionService opinionService;
    
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
       log.info("Creating initial database data");

        // Create root user and group
        User rootUser = createRootUser();
        Group rootGroup = createRootGroup();
        rootGroup.getUsers().add(rootUser);

        // Create dev user and group
        User developerUser = createDeveloperUser();
        Group developerGroup = createDeveloperGroup();
        developerGroup.getUsers().add(developerUser);

        // Create admin user and group
        User adminUser = createAdminUser();
        Group adminGroup = createAdminGroup();
        adminGroup.getUsers().add(adminUser);

        // Create normal user and group
        User user = createUser();
        Group userGroup = createUserGroup();
        userGroup.getUsers().add(user);

        log.info("Initial database data created!");



        // Authenticate the root user
        logInAsRoot();



        log.info("Creating test data");
        createOpinionTestData();
        log.info("Test data created!");
    }

    private User createRootUser() {
        User user = new User("root", "");
//        user.getUserRoles().addAll(Arrays.asList(Role.values()));
        return userService.create(user);
    }

    private Group createRootGroup() {
        Group group = new Group("root");
        group.getGroupRoles().addAll(Arrays.asList(Role.values()));
        return groupService.create(group);
    }

    private User createDeveloperUser() {
        User user = new User("developer", "");
        user.getUserRoles().add(Role.ROLE_DEVELOPER);
        user.getUserRoles().add(Role.ROLE_ADMIN);
        user.getUserRoles().add(Role.ROLE_USER);
        return userService.create(user);
    }

    private Group createDeveloperGroup() {
        Group group = new Group("developer");
        group.getGroupRoles().add(Role.ROLE_DEVELOPER);
        group.getGroupRoles().add(Role.ROLE_ADMIN);
        group.getGroupRoles().add(Role.ROLE_USER);
        return groupService.create(group);
    }

    private User createAdminUser() {
        User user = new User("admin", "");
        user.getUserRoles().add(Role.ROLE_ADMIN);
        user.getUserRoles().add(Role.ROLE_USER);
        return userService.create(user);
    }

    private Group createAdminGroup() {
        Group group = new Group("admin");
        group.getGroupRoles().add(Role.ROLE_ADMIN);
        group.getGroupRoles().add(Role.ROLE_USER);
        return groupService.create(group);
    }

    private User createUser() {
        User user = new User("user", "");
        user.getUserRoles().add(Role.ROLE_USER);
        return userService.create(user);
    }

    private Group createUserGroup() {
        Group group = new Group("user");
        group.getGroupRoles().add(Role.ROLE_USER);
        return groupService.create(group);
    }

    private void createOpinionTestData() {
        log.info("Creating opinions");
        Opinion opinion = new Opinion("Test", "Lalala");
        Opinion opinion2 = new Opinion("Test", "Lalala");
        opinionService.create(opinion);
        opinionService.create(opinion2);
    }

    private void logInAsRoot() throws UsernameNotFoundException {
        UserDetails userDetails = userDetailService.loadUserByUsername("root");
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
