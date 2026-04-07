package com.example.apialunos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDTO {

    @NotBlank(message = "Name is obrigatory")
    @JsonProperty("name")
    private String name;

    @Email(message = "This Email is invalid")
    @NotBlank(message = "Email is mandatory")
    private String email;
}