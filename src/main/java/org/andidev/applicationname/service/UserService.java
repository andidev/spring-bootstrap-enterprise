package org.andidev.applicationname.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.andidev.applicationname.domain.User;
import org.andidev.applicationname.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author anders
 */
@Service
@Transactional
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Boolean create(User user) {
        // create entity
        user.getUserRole().setUser(user);
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

        // change entity
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.getUserRole().setRole(user.getUserRole().getRole());

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
}
