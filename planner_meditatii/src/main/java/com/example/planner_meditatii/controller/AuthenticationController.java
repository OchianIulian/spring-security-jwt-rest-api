package com.example.planner_meditatii.controller;

import com.example.planner_meditatii.auth.AuthenticationRequest;
import com.example.planner_meditatii.auth.AuthenticationResponse;
import com.example.planner_meditatii.mails.token.ConfirmationTokenService;
import com.example.planner_meditatii.service.AuthenticationService;
import com.example.planner_meditatii.auth.RegisterRequest;
import com.example.planner_meditatii.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * In aceasta clasa se gasesc endpointurile pentru authentificarea si inregistrarea utilizatorilor
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/confirm_email")
    public String confirm(@RequestParam("token") String token) {
        return service.confirmToken(token);
    }

}
