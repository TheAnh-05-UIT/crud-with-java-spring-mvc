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

    public User handleUpdateUserById(Long id, User user) {
        User updateUserById = this.handleGetUserById(id);
        // updateUserById.setEmail(user.getEmail());
        updateUserById.setFullName(user.getFullName());
        updateUserById.setAddress(user.getAddress());
        updateUserById.setPhone(user.getPhone());
        return this.userRepository.save(updateUserById);
    }

    public void handleDeleteUserById(Long id) {
        User deleteUserById = this.handleGetUserById(id);
        if (deleteUserById != null) {
            this.userRepository.deleteById(id);
        }
    }
}
