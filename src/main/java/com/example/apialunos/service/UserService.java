package com.example.apialunos.service;

import com.example.apialunos.dto.UserRequestDTO;
import com.example.apialunos.exception.ResourceNotFoundException;
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

    public List<User> list() {
        return repository.findAll();
    }

    public User SearchForId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public User create(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        return repository.save(user);
    }

    public User update(Long id, UserRequestDTO dto) {
        User user = SearchForId(id);

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        return repository.save(user);
    }

    public void delete(Long id) {
        User user = SearchForId(id);
        repository.delete(user);
    }
}