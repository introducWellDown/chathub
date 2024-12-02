package com.example.TalkHub.controller;

import com.example.TalkHub.models.PostModel;
import com.example.TalkHub.service.WallServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class PostController {

    private final WallServiceImpl wallService;

    @GetMapping("posts/getList")
    public ResponseEntity<?> getAllPosts() {
        try {
            List<PostModel> posts = wallService.getAllPosts();
            return ResponseEntity.ok(posts);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("posts/add")
    public ResponseEntity<?> addPost(@RequestBody PostModel post) {

        try {
            wallService.addPost(post);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
