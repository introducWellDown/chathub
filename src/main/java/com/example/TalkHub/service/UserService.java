package com.example.TalkHub.service;

import com.example.TalkHub.models.UserModel;


public interface UserService {
    void deleteUserbyId(Long id);
    void addUser(UserModel userModel);
}
