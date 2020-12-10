package com.pixel.challenge.healthcare.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @Value("${page.welcome}")
    private String page;

    @GetMapping("/")
    public String main(Model model) {
    	model.addAttribute("page", page);

        return "welcome"; 
    }
    

}