package com.java.springmvc.Controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.java.springmvc.domain.User;
import com.java.springmvc.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // url trang chủ
    @GetMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.Program();
        model.addAttribute("Hello", test);
        return "Hello";
    }

    // url trang user
    @GetMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.handleGetAllUsers();
        model.addAttribute("users", users);
        return "admin/user/view-user";
    }

    // url trang hiện thị thông tin có id tương ứng
    @GetMapping("/admin/user/{id}")
    public String getUserById(Model model, @PathVariable("id") Long id) {
        User userById = this.userService.handleGetUserById(id);
        model.addAttribute("userById", userById);
        return "admin/user/detail-user";
    }

    // url trang tạo 1 user mới
    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create-user";
    }

    // url lấy thông tin của user từ FE để BE xử lý
    @PostMapping("/admin/user/create")
    public String getUserForm(
            @ModelAttribute("newUser") User user,
            Model model,
            @RequestParam("avatarFile") MultipartFile file) {
        String avatarName = this.userService.handleStorefile(file, "avatar");
        user.setAvatar(avatarName);
        this.userService.handleCreateUser(user);
        return "redirect:/admin/user";
    }

    // url trang cập nhật thông tin user
    @GetMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(
            @PathVariable("id") Long id,
            Model model) {
        User updateUserById = this.userService.handleGetUserById(id);
        model.addAttribute("updateUser", updateUserById);
        return "admin/user/update-user";
    }

    // url lấy thông tin của user từ FE để BE xử lý
    @PostMapping("/admin/user/update")
    public String getUpdateUserForm(
            @ModelAttribute("updateUser") User user,
            Model model,
            @RequestParam("updateFileAvatar") MultipartFile updateFile) {
        this.userService.handleUpdateUserById(user.getId(), user, updateFile);
        return "redirect:/admin/user";
    }

    // url xóa 1 người dùng theo id
    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(
            @PathVariable("id") Long id,
            Model model) {
        model.addAttribute("id", id);
        model.addAttribute("deleteUser", new User());
        return "admin/user/delete-user";
    }

    // url confirm khi xóa 1 người dùng theo id
    @PostMapping("/admin/user/delete")
    public String getDeleteUserConfirm(
            @ModelAttribute("deleteUser") User user,
            Model model) {
        this.userService.handleDeleteUserById(user.getId());
        return "redirect:/admin/user";
    }
}
