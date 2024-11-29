package com.example.TalkHub.reposytory;

import com.example.TalkHub.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposytory extends JpaRepository<UserModel,Long> {
}
