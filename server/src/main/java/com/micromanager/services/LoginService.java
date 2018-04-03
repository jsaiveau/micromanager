package com.micromanager.services;

import com.micromanager.models.LoginResponse;

public interface LoginService {
    public LoginResponse login(String username, String password);
}
