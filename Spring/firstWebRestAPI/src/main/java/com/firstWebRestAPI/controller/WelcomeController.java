package com.firstWebRestAPI.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome() {
        return "Welcome to my Spring API!";
    }

    @GetMapping("/user")
    public String users() {
        return "Authorized user";
    }

    @GetMapping("/manager")
    public String managers(){
        return "Autorized manager";
    }



}
