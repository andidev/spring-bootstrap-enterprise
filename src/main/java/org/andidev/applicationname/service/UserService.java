package org.andidev.applicationname.service;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.User;
import org.andidev.applicationname.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UserService {

    @Inject
    private PasswordEncoder passwordEncoder;
    @Inject
    private UserRepository userRepository;

    public User create(User user) {
        log.info("Creating {} user", user.getUsername());

        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Cannot create user with username  \"" + user.getUsername() + "\" , the username is already in use by another user." );
        }

        // Encode password
        user.setPassword(encryptPassword(user.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        if (user.getAutomaticLogoutTime() == null) {
            user.setAutomaticLogoutTime(60);
        }

        // create entity
        return userRepository.save(user);
    }

    public User update(User user) {
        if (userRepository.findByIdNotAndUsername(user.getId(), user.getUsername()) != null) {
            throw new RuntimeException("Cannot update user with username  \"" + user.getUsername() + "\" , the username is already in use by another user." );
        }

        // save entity
        return userRepository.save(user);
    }

    public void delete(User user) {
        // delete entity
        userRepository.delete(user);
    }

    private String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
