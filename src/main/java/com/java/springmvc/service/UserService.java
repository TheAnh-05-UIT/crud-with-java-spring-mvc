package com.java.springmvc.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.springmvc.domain.Role;
import com.java.springmvc.domain.User;
import com.java.springmvc.repository.RoleRepository;
import com.java.springmvc.repository.UserRepository;

import jakarta.servlet.ServletContext;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ServletContext servletContext;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
            ServletContext servletContext,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.servletContext = servletContext;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String Program() {
        return "hello service";
    }

    public User handleCreateUser(User user) {
        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        user.setRole(this.handleGetRoleByName(user.getRole().getName()));
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

    public User handleUpdateUserById(Long id, User user, MultipartFile file) {
        User updateUserById = this.handleGetUserById(id);
        updateUserById.setFullName(user.getFullName());
        updateUserById.setAddress(user.getAddress());
        updateUserById.setPhone(user.getPhone());

        Role updateRoleName = this.handleGetRoleByName(user.getRole().getName());
        updateUserById.setRole(updateRoleName);

        String fileName = file.getOriginalFilename();
        if (fileName != null && !fileName.equals("")) {
            String updateFileName = this.handleStorefile(file, "avatar");
            if (!updateFileName.equals("")) {
                updateUserById.setAvatar(updateFileName);
            }
        }
        return this.userRepository.save(updateUserById);
    }

    public void handleDeleteUserById(Long id) {
        User deleteUserById = this.handleGetUserById(id);
        if (deleteUserById != null) {
            this.userRepository.deleteById(id);
        }
    }

    public String handleStorefile(MultipartFile file, String targetFolder) {
        if (file.isEmpty()) {
            return "";
        }
        String fileName = "";
        try {
            byte[] bytes;
            bytes = file.getBytes();

            String rootPath = this.servletContext.getRealPath("/resources/images");
            File dir = new File(rootPath + File.separator + targetFolder);
            if (!dir.exists())
                dir.mkdirs();
            // Create the file on server
            fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
            File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public Role handleGetRoleByName(String roleName) {
        return this.roleRepository.findByName(roleName);
    }
}
