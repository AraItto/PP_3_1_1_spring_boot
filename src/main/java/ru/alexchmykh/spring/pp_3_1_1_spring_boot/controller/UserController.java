package ru.alexchmykh.spring.pp_3_1_1_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alexchmykh.spring.pp_3_1_1_spring_boot.model.User;
import ru.alexchmykh.spring.pp_3_1_1_spring_boot.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.getListUsers());
        return "users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(User user, Model model) {
        model.addAttribute("user", user);
        return "user-info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") long userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        return "user-info";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") long userId) {
        userService.deleteUserById(userId);
        return "redirect:/";
    }
}
