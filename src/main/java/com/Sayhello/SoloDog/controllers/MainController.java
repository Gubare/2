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

    @GetMapping("/EDT")
    public String EDT(Model model) {
        model.addAttribute("title", "Редактирование профиля");
        return "editing";
    }


    @PostMapping("/EDT")
    public String LKEDT(Model model) {
        model.addAttribute("title", "Переход в редактирование");
        return "redirect:/EDT";
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

    @PostMapping("/home")
    public String redhome(Model model) {
        model.addAttribute("title", "Переход на главную");
        return "redirect:/";
    }

    @GetMapping("/ENT")
    public String ENT(Model model) {
        model.addAttribute("title", "Авторизация");
        return "enter";
    }
    @PostMapping("/ENT/LK")
    public String ENTLK(Model model) {
        model.addAttribute("title", "Переход в кабинет");
        return "redirect:/LK";
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