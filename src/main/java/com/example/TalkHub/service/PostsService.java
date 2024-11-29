package com.example.TalkHub.service;

import com.example.TalkHub.models.PostModel;

import java.util.List;

public interface PostsService {
    void addPost(PostModel postModel);
    List<PostModel> getAllPosts();
}
