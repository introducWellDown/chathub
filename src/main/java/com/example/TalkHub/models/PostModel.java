package com.example.TalkHub.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


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

    public PostModel(LocalDateTime dateNow, Integer ownerId, String body){
        this.dateNow = dateNow;
        this.ownerId = ownerId;
        this.body = body;
    }

}
