package com.example.planner_meditatii.controller;

import com.example.planner_meditatii.service.DemoService;
import com.example.planner_meditatii.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

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

//    @DeleteMapping("/delete")
//    public void deleteUser(Authentication authentication){
//        demoService.deleteByUsername(demoService.currentEmail(authentication));
//    }






}
