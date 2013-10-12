package org.andidev.applicationname.service;

import javax.inject.Inject;
import org.andidev.applicationname.entity.User;
import org.andidev.applicationname.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anders
 */
@Service
@Transactional
public class UserService {

    @Inject
    private PasswordEncoder passwordEncoder;

    @Inject
    private UserRepository userRepository;

    public Boolean create(User user) {

        // Encode password
        user.setPassword(encryptPassword(user.getPassword()));

        // create entity
        User saved = userRepository.save(user);
        if (saved == null) {
            return false;
        }

        return true;
    }

    public Boolean update(User user) {
        // find entity
        User existingUser = userRepository.findOne(user.getId());
        if (existingUser == null) {
            return false;
        }

        // update entity
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setRoles(user.getRoles());

        // save entity
        User saved = userRepository.save(existingUser);
        if (saved == null) {
            return false;
        }

        return true;
    }

    public Boolean delete(User user) {
        // find entity
        User existingUser = userRepository.findOne(user.getId());
        if (existingUser == null) {
            return false;
        }

        // delete entity
        userRepository.delete(existingUser);
        User deletedUser = userRepository.findOne(user.getId());
        if (deletedUser != null) {
            return false;
        }

        return true;
    }

    private String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
