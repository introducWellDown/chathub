package com.example.TalkHub.service;

import com.example.TalkHub.models.PostModel;

import java.util.List;

public interface WallService {
    List<PostModel> getAllPosts();
    void addPost(PostModel post);
}
