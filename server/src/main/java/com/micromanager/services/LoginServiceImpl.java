package com.micromanager.services;

import com.micromanager.models.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public LoginResponse login(String username, String password) {
        if(username.equals("admin@micromanager.com") && password.equals("admin")) {
            return new LoginResponse(1, "Administrator", "admin@micromanager.com", "fake-token");
        }

        return null;
    }
}
