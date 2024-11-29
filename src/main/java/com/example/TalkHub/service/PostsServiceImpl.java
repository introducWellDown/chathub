package com.example.TalkHub.service;

import com.example.TalkHub.models.PostModel;
import com.example.TalkHub.reposytory.PostReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsServiceImpl implements PostsService {

    private final PostReposytory postReposytory;

    @Autowired
    public PostsServiceImpl (PostReposytory postReposytory) {
        this.postReposytory = postReposytory;
    }

    @Override
    public List<PostModel> getAllPosts() {
        return postReposytory.findAll();
    }

    @Override
    public void addPost(PostModel postModel) {
        postReposytory.save(postModel);
    }
}
