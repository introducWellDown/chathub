package com.example.TalkHub.service;

import com.example.TalkHub.models.PostModel;
import com.example.TalkHub.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WallServiceImpl implements WallService {

    private final PostRepository postRepository;

    @Autowired
    public WallServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostModel> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void addPost(PostModel postModel) {
        postRepository.save(postModel);
    }
}
