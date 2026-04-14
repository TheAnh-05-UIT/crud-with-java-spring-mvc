package com.java.springmvc.service;

import java.util.List;

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
}
