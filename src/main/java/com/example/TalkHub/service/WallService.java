package com.example.TalkHub.service;

import com.example.TalkHub.models.PostModel;

import java.util.List;

public interface WallService {
    List<PostModel> getPosts(int page, int size);
    void addPost(PostModel post);
    PostModel getPostById(Long id);
}

