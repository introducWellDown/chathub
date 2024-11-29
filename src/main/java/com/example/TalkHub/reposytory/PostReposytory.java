package com.example.TalkHub.reposytory;

import com.example.TalkHub.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostReposytory extends JpaRepository<PostModel,Long> {
}
