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

    @GetMapping("/LK")
    public String LK(Model model) {
        model.addAttribute("title", "Личный кабинет");
        return "account";
    }
    @GetMapping("/RG")
    public String RG(Model model) {
        model.addAttribute("title", "Регистрация");
        return "registration";
    }

    @PostMapping("/RG/LK")
    public String RGLK(Model model) {
        model.addAttribute("title", "Регистрация");
        return "redirect:/LK";
    }

    @PostMapping("/RG/home")
    public String RGhome(Model model) {
        model.addAttribute("title", "Регистрация");
        return "redirect:/";
    }

    @GetMapping("/ENT")
    public String ENT(Model model) {
        model.addAttribute("title", "Авторизация");
        return "enter";
    }
    @PostMapping("/ENT/LK")
    public String ENTLK(Model model) {
        model.addAttribute("title", "Авторизация");
        return "redirect:/LK";
    }


    @GetMapping("/about")
    public String obo(Model model) {
        model.addAttribute("title", "Авторизация");
        return "about";
    }


}