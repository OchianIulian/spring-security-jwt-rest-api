package com.example.planner_meditatii.controller;

import com.example.planner_meditatii.service.DemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {
    DemoService demoService;
    @GetMapping("/hellomsg")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

    @GetMapping("/current-user-details")
    public String getAuthenticatedUserDetails(Authentication authentication){
        return  demoService.currentUserDetails(authentication);
    }

    @GetMapping("/current-email")
    public String getCurrentEmail(Authentication authentication){
        return demoService.currentEmail(authentication);
    }

    @GetMapping("/is-locked")
    public String isLocked(Authentication authentication){
        return demoService.isLocked(authentication);
    }
    @GetMapping("/is_expired")
    public String isExpired(Authentication authentication){
        return demoService.isExpired(authentication);
    }
    @GetMapping("/is_enabled")
    public String isEnabled(Authentication authentication){
        return demoService.isEnabled(authentication);
    }





}
