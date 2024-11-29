package com.example.TalkHub.service;

import com.example.TalkHub.models.UserModel;
import com.example.TalkHub.reposytory.UserReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    private final UserReposytory userReposytory;

    @Autowired
    public UserServiceImpl(UserReposytory userReposytory){
        this.userReposytory = userReposytory;
    }

    @Override
    public void addUser(UserModel userModel){
        userReposytory.save(userModel);
    }

    @Override
    public void deleteUserbyId(Long id) {
        userReposytory.deleteById(id);
    }
}
