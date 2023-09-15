package com.ldslab02.alugarAutomovel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ldslab02.alugarAutomovel.models.User;
import com.ldslab02.alugarAutomovel.services.UserService;

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = this.userService.findbyIdUser(id);
        return ResponseEntity.ok().body(obj);
    }
}
