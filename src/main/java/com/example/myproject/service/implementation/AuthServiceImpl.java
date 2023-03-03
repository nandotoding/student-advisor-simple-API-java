package com.example.myproject.service.implementation;

import com.example.myproject.exception.UnauthorizedException;
import com.example.myproject.model.request.Credential;
import com.example.myproject.service.AuthService;
import com.example.myproject.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    private final List<String> tokenStorage = new ArrayList<>();
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String login(Credential credential) {
        if (credential.getUsername().equals("nando") && credential.getPassword().equals("1234")) {
            String token = jwtUtil.generateToken("Whatever");
            tokenStorage.add(token);
            return token;
        } else {
            throw new UnauthorizedException("Invalid username or password");
        }
    }

    @Override
    public boolean validateToken(String token) {
        String existingToken = null;

        for (String t : tokenStorage) {
            if (t.equals(token)) {
                existingToken = t;
                break;
            }
        }

        if (existingToken == null) {
            throw new UnauthorizedException("Token is not exist");
        }

        if (jwtUtil.validateToken(existingToken)) {
            return true;
        } else {
            throw new UnauthorizedException("Token is invalid");
        }
    }

    @Override
    public boolean logout(String token) {
        return tokenStorage.remove(token);
    }
}
