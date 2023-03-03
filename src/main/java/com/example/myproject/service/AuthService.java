package com.example.myproject.service;

import com.example.myproject.model.request.Credential;

public interface AuthService {
    public String login(Credential credential);
    public boolean validateToken(String token);
    public boolean logout(String token);
}
