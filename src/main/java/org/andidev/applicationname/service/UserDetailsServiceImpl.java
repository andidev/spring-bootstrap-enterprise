package org.andidev.applicationname.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.User;
import org.andidev.applicationname.entity.enums.Role;
import org.andidev.applicationname.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Inject
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            log.info("Logging in with username = " + username);
            User user = userRepository.findByUsername(username);

            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    convertToGrantedAuthorities(user.getUserRoles()));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Collection<? extends GrantedAuthority> convertToGrantedAuthorities(Set<Role> userRoles) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (Role userRole : userRoles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(userRole.name()));
        }
        return grantedAuthorities;
    }
}
