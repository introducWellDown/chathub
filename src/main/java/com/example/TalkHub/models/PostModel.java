package com.example.TalkHub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "posts")
@Entity
@AllArgsConstructor
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateNow;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private UserModel user;

    public PostModel() {
    }

    public PostModel(UserModel user, String body) {
        this.user = user; // Используем поле user вместо ownerId
        this.body = body;
    }

    @PrePersist
    protected void onCreate() {
        this.dateNow = LocalDateTime.now();
    }
}
