package com.example.TalkHub.controller;

import com.example.TalkHub.models.PostModel;
import com.example.TalkHub.models.UserModel;
import com.example.TalkHub.repository.UserReposytory;
import com.example.TalkHub.service.WallServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final WallServiceImpl wallService;
    private final UserReposytory userRepository;

    @GetMapping("/getList")
    public ResponseEntity<?> getAllPosts(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "4") int size) {
        try {
            List<PostModel> posts = wallService.getPosts(page, size);
            List<Map<String, Object>> response = posts.stream().map(post -> {
                Map<String, Object> postMap = new HashMap<>();
                postMap.put("id", post.getId());
                postMap.put("dateNow", post.getDateNow());
                postMap.put("body", post.getBody());
                postMap.put("author", post.getUser().getName());
                return postMap;
            }).collect(Collectors.toList());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPost(@RequestBody PostModel post, Principal principal) {
        try {
            if (principal == null) {
                return ResponseEntity.status(401).body(Map.of("error","Unauthorized"));
            }
            String username = principal.getName();
            UserModel user = userRepository.findByName(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            post.setUser(user);
            wallService.addPost(post);
            // Возвращаем JSON-ответ
            return ResponseEntity.ok(Map.of("message","Пост успешно добавлен"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error","Bad request"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@PathVariable Long id) {
        try {
            PostModel post = wallService.getPostById(id);
            return ResponseEntity.ok(post);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

