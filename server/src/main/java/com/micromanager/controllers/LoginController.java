package com.micromanager.controllers;

import com.micromanager.models.LoginRequest;
import com.micromanager.models.LoginResponse;
import com.micromanager.models.VerifyTokenResponse;
import com.micromanager.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(path = "/api/authenticate", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> signin(@RequestBody LoginRequest loginUser) {
        LoginResponse response = loginService.login(loginUser.getEmail(), loginUser.getPassword());
        if(response ==  null) {
            return new ResponseEntity<LoginResponse>(response, HttpStatus.UNAUTHORIZED);
        }else {
            return new ResponseEntity<LoginResponse>(response, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/api/verify")
    public ResponseEntity<?> verifyToken(@RequestHeader(value="Authorization", required=false) String auth) {
        if(auth != null && auth.startsWith("Bearer")) {
            return new ResponseEntity<>(new VerifyTokenResponse("ok"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        }
    }
}
