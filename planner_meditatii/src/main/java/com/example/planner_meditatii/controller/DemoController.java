package com.example.planner_meditatii.controller;

import com.example.planner_meditatii.service.DemoService;
import com.example.planner_meditatii.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * In aceasta clasa se gasesc endpointurile ce sunt accesibile utilizatorului dupa ce s-a logat
 */
@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {
    private DemoService demoService;
    @Autowired
    UserRepository userRepository;

    //e acelasi lucru cu this.studentService = new StudentService();
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

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

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(Authentication authentication) {
        if (demoService != null) {
            demoService.deleteByUsername(authentication);
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Demo service is not initialized");
        }
    }
}
