package com.ldslab02.alugarAutomovel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldslab02.alugarAutomovel.models.User;

import com.ldslab02.alugarAutomovel.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> autenticateUser(@Valid @RequestBody User obj) {
        User user = null;
        String login = obj.getLogin();
        try {
            user = this.userService.findByLoginUser(login);
            if (user != null) {
                user.setPassword(null);
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build(); // ou outra resposta apropriada, se o usuário não for
                                                          // encontrado
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("O campo 'login' deve ser um número válido.");
        }
    }

}
