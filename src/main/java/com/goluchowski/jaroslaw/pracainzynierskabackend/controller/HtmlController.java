package com.goluchowski.jaroslaw.pracainzynierskabackend.controller;

import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Miasta;
import com.goluchowski.jaroslaw.pracainzynierskabackend.model.Trenerzy;
import com.goluchowski.jaroslaw.pracainzynierskabackend.repository.MiastaRepository;
import com.goluchowski.jaroslaw.pracainzynierskabackend.repository.TrenerzyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HtmlController {

    @Autowired
    TrenerzyRepository trenerzyRepository;

    @Autowired
    MiastaRepository miastaRepository;

    @GetMapping("/admin/addTrainer")
    public String sendTrainerForm(@ModelAttribute("trener") Trenerzy trener) {
        return "/admin/addTrainer";
    }

    @PostMapping("/admin/addTrainer")
    public String processTrainerForm(@ModelAttribute("trener") Trenerzy trener) {
        trenerzyRepository.save(trener);
        return "/admin/showMessageTrainer";
    }

    @GetMapping("/admin/addCity")
    public String sendCityForm(@ModelAttribute("miasto") Miasta miasto) {
        return "/admin/addCity";
    }

    @PostMapping("/admin/addCity")
    public String processCityForm(@ModelAttribute("miasto") Miasta miasto) {
        miastaRepository.save(miasto);
        return "/admin/showMessageCity";
    }

    @GetMapping("/")
    public String home1() {
        return "home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String redirect() {
        return "/admin/addTrainer";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }


}