package com.java.springmvc.Controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.springmvc.domain.User;
import com.java.springmvc.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // url trang chủ
    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.Program();
        model.addAttribute("Hello", test);
        return "Hello";
    }

    // url trang user
    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.handleGetAllUsers();
        model.addAttribute("users", users);
        return "admin/user/table-user";
    }

    // url trang hiện thị thông tin có id tương ứng
    @RequestMapping("/admin/user/{id}")
    public String getUserById(Model model, @PathVariable("id") Long id) {
        User userById = this.userService.handleGetUserById(id);
        model.addAttribute("userById", userById);
        return "admin/user/view-user";
    }

    // url trang tạo 1 user mới
    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create-user";
    }

    // url lấy thông tin của user từ FE để BE xử lý
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String getUserForm(
            @ModelAttribute("newUser") User user,
            Model model) {
        this.userService.handleCreateUser(user);
        return "redirect:/admin/user";
    }

    // url trang cập nhật thông tin user
    @RequestMapping(value = "/admin/user/update/{id}")
    public String getUpdateUserPage(
            @PathVariable("id") Long id,
            Model model) {
        User updateUserById = this.userService.handleGetUserById(id);
        model.addAttribute("updateUser", updateUserById);
        return "admin/user/update-user";
    }

    // url lấy thông tin của user từ FE để BE xử lý
    @RequestMapping(value = "/admin/user/update", method = RequestMethod.POST)
    public String getUpdateUserForm(
            @ModelAttribute("updateUser") User user,
            Model model) {
        // System.out.print(user.getId());
        // model.addAttribute("updateUser", new User());
        this.userService.handleUpdateUserById(user.getId(), user);
        return "redirect:/admin/user";
    }

    // url xóa 1 người dùng theo id
    @RequestMapping(value = "/admin/user/delete/{id}")
    public String getDeleteUserPage(
            @PathVariable("id") Long id,
            Model model) {
        model.addAttribute("id", id);
        model.addAttribute("deleteUser", new User());
        return "admin/user/delete-user";
    }

    @RequestMapping(value = "/admin/user/delete", method = RequestMethod.POST)
    public String getDeleteUserConfirm(
            @ModelAttribute("deleteUser") User user,
            Model model) {
        // model.addAttribute("deleteUser", new User());
        this.userService.handleDeleteUserById(user.getId());
        return "redirect:/admin/user";
    }
}
