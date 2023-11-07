package com.heitor.softwareEngineering.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heitor.softwareEngineering.domain.User.User;
import com.heitor.softwareEngineering.domain.User.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(String username) {
        User user = new User();
        user.setUsername(username);
        return userRepository.save(user);
    }

    public User updateUser(Long userId, String newUsername) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(newUsername);
            return userRepository.save(user);
        }
        
        return null;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
