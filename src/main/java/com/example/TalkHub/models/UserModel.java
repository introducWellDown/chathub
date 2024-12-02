package com.example.TalkHub.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
public class UserModel {

    public enum Gender {
        man,
        women
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String activationCode;
    private String authProvider;
    private LocalDateTime createdAt;
    private boolean isActivated;


    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String name;
    private Integer age;
    private String password;
    private String email;

    public UserModel() {
    }

    public UserModel(String name, Gender gender, Integer age,String password, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.password = password;
        this.email = email;
    }

    @PrePersist
    void onCreate() {
        this.activationCode = "";
        this.createdAt = LocalDateTime.now();
        this.isActivated = false;
        this.authProvider = "local";
    }
}
