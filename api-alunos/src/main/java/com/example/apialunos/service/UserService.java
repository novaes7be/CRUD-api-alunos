package com.example.apialunos.service;

import com.example.apialunos.model.User;
import com.example.apialunos.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> listar() {
        return repository.findAll();
    }

    public User buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User não encontrado"));
    }

    public User criar(User user) {
        return repository.save(user);
    }

    public User atualizar(Long id, User userAtualizado) {
        User user = buscarPorId(id);

        user.setName(userAtualizado.getName());
        user.setEmail(userAtualizado.getEmail());

        return repository.save(user);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}