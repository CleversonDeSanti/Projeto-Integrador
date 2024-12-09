package com.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ProfileController {

    private static final List<Map<String, String>> profiles = List.of(
            Map.of("id", "123", "name", "João Silva", "description", "Encanador e serviços de limpeza geral, comercial e residencial.", "email", "joao@exemplo.com", "phone", "(11) 1234-5678", "image", "/images/Encanador.jpg"),
            Map.of("id", "124", "name", "Mariana Costa", "description", "Designer Gráfico. Expresso em imagens criativas o sonho das pessoas!", "email", "mariana@exemplo.com", "phone", "(11) 9876-5432", "image", "/images/Designer.png"),
            Map.of("id", "125", "name", "Maria de Oliveira", "description", "Serviços de faxina residencial, de forma diária, semanal e mensal.", "email", "maria@exemplo.com", "phone", "(11) 9876-5432", "image", "/images/Faxineira.jpg"),
            Map.of("id", "126", "name", "Carlos Almeida", "description", "Presto serviços de jardinagem residencial e comercial.", "email", "carlos@exemplo.com", "phone", "(21) 1122-3344", "image", "/images/Jardineiro.jpg"),
            Map.of("id", "127", "name", "José dos Santos", "description", "Fazemos fretes e mudanças para todo o Brasil.", "email", "jose@exemplo.com", "phone", "(31) 2233-4455", "image", "/images/Mudança.jpg")
    );

    @GetMapping("/profiles")
    public String home(Model model) {
        model.addAttribute("profiles", profiles);
        return "home";
    }

    @GetMapping("/visualizar-perfil")
    public String visualizarPerfil(@RequestParam String id, Model model) {
        Map<String, String> profile = profiles.stream().filter(p -> p.get("id").equals(id)).findFirst().orElse(null);
        model.addAttribute("profile", profile);
        return "visualizar-perfil";
    }
}
