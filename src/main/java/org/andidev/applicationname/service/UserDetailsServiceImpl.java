package org.andidev.applicationname.service;

import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.User;
import org.andidev.applicationname.entity.enums.UserRole;
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
                    convertToGrantedAuthorities(user.getUserRole()));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<GrantedAuthority> convertToGrantedAuthorities(UserRole role) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.name());
        return Lists.newArrayList(grantedAuthority);
    }   
}
