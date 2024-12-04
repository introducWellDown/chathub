package com.example.TalkHub.service;

import com.example.TalkHub.DTO.LoginRequest;
import com.example.TalkHub.models.UserModel;
import com.example.TalkHub.repository.UserReposytory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.function.*;


@Service("authService")
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserReposytory userReposytory;

    @Override
    public void register(UserModel user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userReposytory.save(user);
    }


    @Override
    public UserModel authenticate(LoginRequest request) {
        UserModel user = userReposytory.findByName(request.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            return user;
        } else {
            throw new RuntimeException("Invalid Credentials");
        }
    }
}
