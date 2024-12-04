package com.example.TalkHub.repository;

import com.example.TalkHub.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserReposytory extends JpaRepository<UserModel,Long> {
    Optional<UserModel> findByName(String name);
}
