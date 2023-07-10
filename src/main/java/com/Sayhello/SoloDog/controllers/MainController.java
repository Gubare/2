package com.Sayhello.SoloDog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }


    @GetMapping("/about")
    public String obo(Model model) {
        model.addAttribute("title", "О нас");
        return "about";
    }
    @GetMapping("/WRD")
    public String WRD(Model model) {
        model.addAttribute("title", "Изучение слов");
        return "word";
    }
    @GetMapping("/TXT")
    public String TXT(Model model) {
        model.addAttribute("title", "Изучение текстов");
        return "text";
    }


}