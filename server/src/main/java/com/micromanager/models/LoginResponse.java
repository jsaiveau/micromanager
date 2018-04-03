package com.micromanager.models;

public class LoginResponse {
    private String fullName;
    private String email;
    private String token;
    private Integer id;

    public LoginResponse() {
    }

    public LoginResponse(Integer id, String fullName, String email, String token) {
        this.fullName = fullName;
        this.email = email;
        this.token = token;
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
