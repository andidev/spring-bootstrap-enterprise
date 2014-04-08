package org.andidev.applicationname.config;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.config.logging.MDC;
import org.andidev.applicationname.entity.Group;
import org.andidev.applicationname.entity.User;
import org.andidev.applicationname.entity.enums.Role;
import org.andidev.applicationname.service.GroupService;
import org.andidev.applicationname.service.UserService;
import static org.andidev.applicationname.util.ApplicationUtils.getUsername;
import static org.andidev.applicationname.util.StringUtils.quote;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
public class ImportSql implements ApplicationListener<ContextRefreshedEvent> {

    @Inject
    private GroupService groupService;
    @Inject
    UserService userService;
    @Inject
    UserDetailsService userDetailsService;

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

        // Login as root user
        login("root");

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

        // Logout root user
        logout();

        log.info("Initial database data created!");


        log.info("Creating test data");
        // Add create test data methods here
        log.info("Test data created!");
    }

    private User createRootUser() {
        User user = new User("root", "");
        return userService.create(user);
    }

    private Group createRootGroup() {
        Group group = new Group("root");
        group.getGroupRoles().addAll(Role.getAllRolesExceptAnonymous());
        return groupService.create(group);
    }

    private User createAnonymousUser() {
        User user = new User("anonymousUser", "");
        user.getUserRoles().add(Role.ROLE_ANONYMOUS);
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

    private void login(String username) throws UsernameNotFoundException {
        MDC.putUsername(username);
        UserDetails user = userDetailsService.loadUserByUsername(username);
        Authentication auth = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        log.info("Logged in as {}", quote(username));
    }

    private void logout() {
        String username = getUsername();
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(null);
        SecurityContextHolder.clearContext();
        log.info("Logged out as {}", quote(username));
        MDC.removeUsername();
    }
}
