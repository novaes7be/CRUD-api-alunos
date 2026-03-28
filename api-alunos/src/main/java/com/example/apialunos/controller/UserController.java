package com.example.apialunos.controller;

import com.example.apialunos.model.User;
import com.example.apialunos.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public User buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public User criar(@RequestBody User user) {
        return service.criar(user);
    }

    @PutMapping("/{id}")
    public User atualizar(@PathVariable Long id, @RequestBody User user) {
        return service.atualizar(id, user);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}