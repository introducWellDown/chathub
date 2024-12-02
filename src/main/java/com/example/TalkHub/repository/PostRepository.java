package com.example.TalkHub.repository;

import com.example.TalkHub.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostModel,Long> {
}
