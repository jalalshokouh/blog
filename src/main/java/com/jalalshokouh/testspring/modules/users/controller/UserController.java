package com.jalalshokouh.testspring.modules.users.controller;

import com.jalalshokouh.testspring.modules.users.entity.Users;
import com.jalalshokouh.testspring.modules.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "registerUser")
    public String showUser (Model model , Users users){
        model.addAttribute("user" , new Users());
        model.addAttribute("users", userService.showUser());
        return "userRegister";
    }

    @PostMapping(value = "registerUser")
    public String registerUser (@ModelAttribute("user") Users users) throws IOException {
        userService.addUser(users);
        System.out.println(users.toString());
        return "redirect:registerUser";
    }

}
