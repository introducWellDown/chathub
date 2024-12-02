package com.example.TalkHub.controller;

import com.example.TalkHub.models.UserModel;
import com.example.TalkHub.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/getInfo")
    public ResponseEntity<?> getInfo(@RequestParam Long id){
        try {
            UserModel userInfo = userService.getUserById(id);
            return ResponseEntity.ok(userInfo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserModel user){
        try {
            userService.addUser(user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
