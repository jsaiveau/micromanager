package com.micromanager.models;

public class VerifyTokenResponse {
    private String status;

    public VerifyTokenResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
