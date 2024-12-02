package com.example.TalkHub.service;

import com.example.TalkHub.models.UserModel;
import com.example.TalkHub.repository.UserReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    private final UserReposytory userReposytory;

    @Autowired
    public UserServiceImpl(UserReposytory userReposytory){
        this.userReposytory = userReposytory;
    }

    @Override
    public void addUser(UserModel user){
        String password = user.getPassword();
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userReposytory.save(user);
    }

    @Override
    public void deleteUserbyId(Long id) {
        userReposytory.deleteById(id);
    }

    @Override
    public UserModel getUserById(Long id) {
        try {
            return userReposytory.findById(id).get();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
