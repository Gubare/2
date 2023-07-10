package com.Sayhello.SoloDog.controllers;
import com.Sayhello.SoloDog.models.User;
import com.Sayhello.SoloDog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/LK/{id}")
    public String LK(@PathVariable(value = "id") long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        user.ifPresent(res::add);
        model.addAttribute("user", res);
        model.addAttribute("title", "Личный кабинет");
        return "account";
    }

    @GetMapping("/EDT/{id}")
    public String EDT(@PathVariable(value = "id") long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        user.ifPresent(res::add);
        model.addAttribute("user", res);
        model.addAttribute("title", "Редактирование профиля");
        return "editing";
    }
    @PostMapping("/EDT/ENT/{id}")
    public String LKEDT(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("title", "Переход в редактирование");
        return "redirect:/EDT/{id}";
    }

    @PostMapping("/EDT/{id}")
    public String EDTLK(@PathVariable(value = "id") long id, @RequestParam String password, @RequestParam String mail,
                        @RequestParam String name, @RequestParam String complexity, @RequestParam String language, Model model) {
        User user = userRepository.findById(id).orElseThrow();
        char code = '#';
        password += code;
        user.setName(name);
        user.setMail(mail);
        user.setPassword(password);
        user.setLanguage(language);
        user.setComplexity(complexity);
        userRepository.save(user);
        model.addAttribute("title", "Выход из редактирования");
        return "redirect:/LK/{id}";
    }


    @GetMapping("/RG")
    public String RG(Model model) {
        model.addAttribute("title", "Регистрация");
        return "registration";
    }

    @PostMapping("/RG/LK")
    public String RGLK(@RequestParam String name, @RequestParam String password, @RequestParam String mail,Model model) {
        char code = '#';
        password += code;
        User user = new User(name, password, mail, null, null);
        userRepository.save(user);
        model.addAttribute("title", "Переход на главную");
        return "redirect:/";
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
//    @PostMapping("/ENT/LK")
//    public String ENTLK(@RequestParam  long id, Model model) {
//        model.addAttribute("title", "Переход в кабинет");
//        return "redirect:/LK/{id}";
//    }

    @PostMapping("/ENT/CHECK")
    public String CHECK(@RequestParam  String id, Model model) {
        model.addAttribute("title", "Переход в кабинет");
        return "redirect:/LK/%s".formatted(id);
    }


}
