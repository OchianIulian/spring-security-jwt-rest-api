package com.example.planner_meditatii.users;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data//Generates getters and setters for the class
@Builder//Build the object with the design pattern builder
@NoArgsConstructor
@AllArgsConstructor//is for @Builder
@EqualsAndHashCode
@Entity
@Table(name = "user_table")
public class User implements UserDetails {
    @Id
    @GeneratedValue//strategy = GenerationType.AUTO
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean locked = false;
    private boolean enabled = false;
    @Enumerated(EnumType.STRING)//tells Spring that role is an enum
    private Role role;


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
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
