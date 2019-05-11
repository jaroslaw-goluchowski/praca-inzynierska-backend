package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultEndpoints {

    @GetMapping("/")
    public String welcomeMessage(){
        return "Backendowa aplikacja na pracę inżynierską";
    }

}
