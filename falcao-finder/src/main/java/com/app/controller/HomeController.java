package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // Exemplo de perfis fictícios
        List<Map<String, String>> profiles = List.of(
                Map.of("id", "123", "name", "João Silva"),
                Map.of("id", "456", "name", "Maria Oliveira")
        );


        model.addAttribute("profiles", profiles);
        return "home"; // Apontar para a página HTML "home.html"
    }

    @GetMapping("/about_us")
    public String showAboutUsPage() {
        return "about_us"; // O nome do arquivo HTML (about_us.html) na pasta templates
    }
}