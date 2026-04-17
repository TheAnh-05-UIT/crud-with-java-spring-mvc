package com.java.springmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.springmvc.domain.User;
import com.java.springmvc.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String Program() {
        return "hello service";
    }

    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> handleGetAllUsers() {
        return this.userRepository.findAll();
    }

    public User handleGetUserById(Long id) {
        Optional<User> getUserById = this.userRepository.findById(id);

        if (getUserById.isPresent()) {
            return getUserById.get();
        }
        return null;
    }
}
