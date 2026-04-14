package com.java.springmvc.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.Program();
        model.addAttribute("Hello", test);
        return "Hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.handleGetAllUsers();
        model.addAttribute("users", users);
        return "admin/user/table-user";
    }

    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create-user";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String getUserForm(
            @ModelAttribute("newUser") User user,
            Model model) {
        this.userService.handleCreateUser(user);
        return "redirect:/admin/user";
    }
}
