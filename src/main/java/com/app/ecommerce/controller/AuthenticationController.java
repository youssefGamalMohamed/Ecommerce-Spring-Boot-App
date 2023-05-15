package com.app.ecommerce.controller;

import com.app.ecommerce.models.request.LoginRequestBody;
import com.app.ecommerce.models.request.RegisterRequestBody;
import com.app.ecommerce.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestBody registerRequestBody) {
        return ResponseEntity.ok(service.register(registerRequestBody));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequestBody loginRequestBody) {
        return ResponseEntity.ok(service.authenticate(loginRequestBody));
    }


}