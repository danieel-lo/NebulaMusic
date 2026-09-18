package com.example.NebulaMusic.controller;

import com.example.NebulaMusic.model.Usuario;
import com.example.NebulaMusic.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final UsuarioService usuarioService;

    public MainController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping({"/index", "/index.html"})
    public String index() {
        return "index";
    }

    @GetMapping({"/registro", "/registro.html"})
    public String registro() {
        return "registro";
    }

    @GetMapping({"/", "/login", "/login.html"})
    public String login() {
        return "login";
    }

    @GetMapping({"/error", "/error.html"})
    public String error() {
        return ("error");
    }

    @PostMapping("/crear-cuenta")
    public String crearCuenta(@ModelAttribute Usuario usuario) {
        usuarioService.registrar(usuario);
        return "redirect:/login";
    }

    @PostMapping("/autenticacion")
    public String autenticacion(@RequestParam("correo") String correo,
                                @RequestParam("contrasenia") String contrasenia) {
        if (usuarioService.autenticar(correo, contrasenia)) {
            return "redirect:/index";
        }
        return "redirect:/error.html";
    }

    @GetMapping("/cerrar-sesion")
    public String cerrarSesion() {
        return "redirect:/login?logout";
    }

}
