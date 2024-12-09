package com.app.controller;

import com.app.model.User;
import com.app.repo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
        userService.saveUser(user); // Salva o usuário
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

    // Endpoint para salvar foto de capa
    @PostMapping("/{id}/uploadCover")
    public ResponseEntity<String> uploadCoverPhoto(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        // Chama o serviço para salvar a foto de capa
        String responseMessage = userService.savePhoto(file, id, "cover");
        return ResponseEntity.ok(responseMessage); // Retorna a resposta ao cliente
    }

    // Endpoint para salvar foto de perfil
    @PostMapping("/{id}/uploadProfile")
    public ResponseEntity<String> uploadProfilePhoto(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        // Chama o serviço para salvar a foto de perfil
        String responseMessage = userService.savePhoto(file, id, "profile");
        return ResponseEntity.ok(responseMessage); // Retorna a resposta ao cliente
    }
}
