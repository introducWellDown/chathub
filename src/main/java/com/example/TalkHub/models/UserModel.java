package com.example.TalkHub.models;


import jakarta.persistence.*;
import lombok.Data;

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

    private String name;
    private Gender gender;
    private Integer age;

    public UserModel(){
    }

    public UserModel(String name, Gender gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
