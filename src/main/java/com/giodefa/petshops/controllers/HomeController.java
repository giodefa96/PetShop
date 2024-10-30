package com.giodefa.petshops.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("message", "Welcome to Pet Shops!");
        model.addAttribute("subMessage", "Find everything you need for your pets.");
        return "home";
    }
}
