package com.example.planner_meditatii.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data//Generates getters and setters for the class
@Builder//Build the object with the design pattern builder
@NoArgsConstructor
@AllArgsConstructor//is for @Builder
@Entity
@Table(name = "_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue//strategy = GenerationType.AUTO
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean locked;
    private boolean enabled;
    @Enumerated(EnumType.STRING)//tells Spring that role is an enum
    private Role role;


    public User(String firstName, String lastName, String email, String password, boolean locked, boolean enabled, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.locked = locked;
        this.enabled = enabled;
        this.role = role;
    }

    //Urmatoarele metode sunt din UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
