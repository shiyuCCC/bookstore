package com.programming3final.bookstore.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login/login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "login/access-denied";
    }

}
