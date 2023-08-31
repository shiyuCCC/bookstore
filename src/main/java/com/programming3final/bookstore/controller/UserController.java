package com.programming3final.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.programming3final.bookstore.entity.User;
import com.programming3final.bookstore.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService theUserService) {
        userService = theUserService;
    }

    @PostMapping("/user/save")
    public String saveUser(@Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            return "login/register";
        } else {
            userService.save(theUser);
            return "redirect:/showMyLoginPage";
        }

    }

    @GetMapping("/showRegistration")
    public String showRegistration(Model theModel) {
        User theUser = new User();
        theModel.addAttribute("user", theUser);
        return "login/register";
    }
}
