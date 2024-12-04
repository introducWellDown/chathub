package com.example.TalkHub.service;

import com.example.TalkHub.DTO.LoginRequest;
import com.example.TalkHub.models.UserModel;

public interface AuthService {
    void register(UserModel user);
    UserModel authenticate(LoginRequest request);
}
