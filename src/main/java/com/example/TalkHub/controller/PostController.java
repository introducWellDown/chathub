package com.example.TalkHub.controller;

import com.example.TalkHub.models.PostModel;
import com.example.TalkHub.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {

    private final PostsService postsService;

    @Autowired
    public PostController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping()
    public List<PostModel> getAllPosts() {
        return postsService.getAllPosts();
    }
}
