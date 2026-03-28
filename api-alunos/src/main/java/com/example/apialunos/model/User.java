package com.example.apialunos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "users")
public class User {

    @Getter
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;


    //Getters e Setters

    @Setter // setter for name
        @Getter
    private String name;

    @Setter // setter for email
        @Getter
    private String email;


    public User() {}

    public User(String name, String email){
        this.name = name;
        this.email = email;

    }
}
