package com.example.planner_meditatii.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {
    public final String currentUserDetails(Authentication authentication){
        // Get the UserDetails object from the Authentication object
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Access UserDetails properties
        String username = userDetails.getUsername();
        String password = userDetails.getPassword();
        boolean accountNonExpired = userDetails.isAccountNonExpired();
        boolean accountNonLocked = userDetails.isAccountNonLocked();
        boolean credentialsNonExpired = userDetails.isCredentialsNonExpired();
        boolean enabled = userDetails.isEnabled();

        // Return UserDetails information
        return "Username: " + username + "Password" + password + ", AccountNonExpired: " + accountNonExpired + ", AccountNonLocked: " +
                accountNonLocked + ", CredentialsNonExpired: " + credentialsNonExpired + ", Enabled: " + enabled;
    }

    public String currentEmail(Authentication authentication) {
        // Get the UserDetails object from the Authentication object
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Access UserDetails properties
        String username = userDetails.getUsername();
        return "Username: " + username;
    }

    public String isLocked(Authentication authentication) {
        // Get the UserDetails object from the Authentication object
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        boolean accountNonLocked = userDetails.isAccountNonLocked();

        return "Is Locked: " + !accountNonLocked;
    }

    public String isExpired(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        boolean accountNonExpired = userDetails.isAccountNonExpired();
        return "Is expired: " + !accountNonExpired;
    }

    public String isEnabled(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        boolean enabled = userDetails.isEnabled();
        return "Is enabled:" + enabled;
    }
}
