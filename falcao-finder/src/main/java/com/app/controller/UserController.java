package com.app.controller;

import com.app.model.User; // Classe para representar usuários
import com.app.repo.UserService; // Serviço para autenticação e gerenciamento de usuários
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Página de Login e Cadastro
    @GetMapping("/loginPage")
    public ModelAndView loginPage() {
        ModelAndView model = new ModelAndView("login");
        model.addObject("loginForm", new User());  // Objeto para formulário de login
        model.addObject("registerForm", new User()); // Objeto para formulário de cadastro
        return model;
    }

    // Endpoint para salvar (cadastrar ou editar) usuário
    @PostMapping("/users/save")
    public ModelAndView saveUser(@ModelAttribute("registerForm") User user) {
        userService.saveUser(user);
        return new ModelAndView("redirect:/loginPage"); // Redireciona para a página de login
    }

    // Endpoint para autenticar o usuário
    @PostMapping("/login")
    public ModelAndView loginUser(@ModelAttribute("loginForm") User user) {
        User authenticatedUser = userService.getAllUser().stream()
                .filter(u -> u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword()))
                .findFirst()
                .orElse(null);

        if (authenticatedUser != null) {
            ModelAndView model = new ModelAndView("perfil"); // Página de perfil do usuário
            model.addObject("user", authenticatedUser);
            return model;
        } else {
            ModelAndView model = new ModelAndView("login");
            model.addObject("loginError", "Usuário ou senha inválidos!");
            model.addObject("registerForm", new User());
            return model;
        }
    }
}
