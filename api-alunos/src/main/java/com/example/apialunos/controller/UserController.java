package com.example.apialunos.controller;

import com.example.apialunos.dto.UserRequestDTO;
import com.example.apialunos.model.User;
import com.example.apialunos.repository.UserRepository;
import com.example.apialunos.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = {
        "http://localhost:5500",
        "http://127.0.0.1:5500"})
public class UserController {

    private final UserService service;
    private final UserRepository userRepository;

    public UserController(UserService service, UserRepository userRepository) {
        this.service = service;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> search(@PathVariable Long id) {
        return ResponseEntity.ok(service.SearchForId(id));
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody UserRequestDTO dto) {
        return ResponseEntity.status(201).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(
            @PathVariable Long id,
            @Valid @RequestBody UserRequestDTO dto) {

        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}