package com.example.TalkHub.config;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.example.TalkHub.models.UserModel;

import java.util.Collection;
import java.util.Collections;

public class UserAuthentication implements Authentication {

    private final UserModel user;
    private boolean authenticated = true;

    public UserAuthentication(UserModel user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // Или установите роли, если они есть
    }

    @Override
    public Object getCredentials() {
        return null; // Пароль не требуется здесь
    }

    @Override
    public Object getDetails() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return user.getName();
    }
}
