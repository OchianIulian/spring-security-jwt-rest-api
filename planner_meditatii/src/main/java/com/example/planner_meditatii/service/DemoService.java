package com.example.planner_meditatii.service;

import com.example.planner_meditatii.users.User;
import com.example.planner_meditatii.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.Optional;


/**
 * Construieste logica requesturilor din DemoController
 */
@Service
@RequiredArgsConstructor
public class DemoService {

    @Autowired
    private final UserRepository userRepository;


    public final String currentUserDetails(Authentication authentication){
        // Get the UserDetails object from the Authentication object
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Access UserDetails properties
        String username = userDetails.getUsername();
        Integer id = userRepository.findByEmail(username).get().getId();
        String password = userDetails.getPassword();
        boolean accountNonExpired = userDetails.isAccountNonExpired();
        boolean accountNonLocked = userDetails.isAccountNonLocked();
        boolean credentialsNonExpired = userDetails.isCredentialsNonExpired();
        boolean enabled = userDetails.isEnabled();

        // Return UserDetails information
        return "ID: " + id + "\nUsername: " + username + "\nPassword: " + password + "\nAccountNonExpired: " + accountNonExpired + "\nAccountNonLocked: " +
                accountNonLocked + "\nCredentialsNonExpired: " + credentialsNonExpired + "\nEnabled: " + enabled;
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

    public void deleteByUsername(Authentication authentication) {
        //Obtain userEmail
        String currentUserEmail;
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;

            // Retrieve the email from the UserDetails object
            currentUserEmail =  userDetails.getUsername().trim(); // Assuming email is stored in the username field
        } else {
            // If the principal is not of type UserDetails, return null or handle the case accordingly
            currentUserEmail = null;
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error at obtaining email");
        }

        // Find the user by username
        Optional<User> userOptional = userRepository.findByEmail(currentUserEmail);
        // Check if the user exists
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Delete the user
            userRepository.delete(user);
        } else {
            // Throw an exception or handle the case where the user does not exist
            //throw new EntityNotFoundException("User with username " + username + " not found");
            System.out.println("user not found by this email");
        }
    }



}
