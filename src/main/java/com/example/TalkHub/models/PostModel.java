package com.example.TalkHub.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@Table(name = "posts")
@Entity
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateNow;
    private Integer ownerId;
    private String body;

    public PostModel(){
    }

    public PostModel (Integer ownerId, String body){
        this.ownerId = ownerId;
        this.body = body;
    }

    @PrePersist
    protected void onCreate(){
        this.dateNow = LocalDateTime.now();
    }
}
