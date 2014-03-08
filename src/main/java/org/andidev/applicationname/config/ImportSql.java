package org.andidev.applicationname.config;

import org.andidev.applicationname.config.logging.MDCInsertingServletFilter;
import java.util.Arrays;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.Group;
import org.andidev.applicationname.entity.User;
import org.andidev.applicationname.entity.enums.Role;
import org.andidev.applicationname.service.GroupService;
import org.andidev.applicationname.repository.UserRepository;
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
    UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Creating initial database data");
        // Create root user and group
        User rootUser = createRootUser();
        Group rootGroup = createRootGroup();
        rootGroup.getUsers().add(rootUser);

        // Create anonymous user and group
        User anonymousUser = createAnonymousUser();

        // Authenticate the root user
        logInAsRoot();
        MDCInsertingServletFilter.putUsernameAndSessionInMDC();

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

        log.info("Creating test data");
        // Add create test data methods here
        log.info("Test data created!");

        MDCInsertingServletFilter.removeUsernameAndSessionFromMDC();
    }

    private User createRootUser() {
        User user = new User("root", "");
        return userService.create(user);
    }

    private Group createRootGroup() {
        Group group = new Group("root");
        group.getGroupRoles().addAll(Arrays.asList(Role.values()));
        return groupService.create(group);
    }

    private User createAnonymousUser() {
        User user = new User("anonymousUser", "");
        return userService.create(user);
    }

    private User createDeveloperUser() {
        User user = new User("developer", "");
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
        return userService.create(user);
    }

    private Group createUserGroup() {
        Group group = new Group("user");
        group.getGroupRoles().add(Role.ROLE_USER);
        return groupService.create(group);
    }

    private void logInAsRoot() throws UsernameNotFoundException {
        UserDetails user = userRepository.findByUsername("root");
        Authentication auth = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
