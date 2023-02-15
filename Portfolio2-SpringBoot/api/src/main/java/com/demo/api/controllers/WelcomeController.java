package com.demo.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WelcomeController {

    @GetMapping
    public String welcome(){
        return "Welcome to Ditha's Simple CRUD";
    }
    
}
