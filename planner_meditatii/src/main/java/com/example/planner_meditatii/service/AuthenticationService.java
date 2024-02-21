package com.example.planner_meditatii.service;

import com.example.planner_meditatii.auth.AuthenticationRequest;
import com.example.planner_meditatii.auth.AuthenticationResponse;
import com.example.planner_meditatii.auth.RegisterRequest;
import com.example.planner_meditatii.users.Role;
import com.example.planner_meditatii.users.User;
import com.example.planner_meditatii.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService service;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        User user = null;
        if(request.getRole() == Role.USER){
            user = authenticate_user(request);
        } else if(request.getRole() == Role.ADMIN){
            user = authenticate_admin(request);
        } else {
            throw new RuntimeException("Must add Role");
        }
        repository.save(user);
        var jwtToken =  service.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private User authenticate_admin(RegisterRequest request) {
        //todo: De trimis mie un email de confirmare ca sa poata deveni admin
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword() ))
                .role(Role.ADMIN)
                .build();
    }

    private User authenticate_user(RegisterRequest request){
        //todo: de trimis email de confirmare pe mailul utilizatorului
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword() ))
                .role(Role.USER)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user= repository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken =  service.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
