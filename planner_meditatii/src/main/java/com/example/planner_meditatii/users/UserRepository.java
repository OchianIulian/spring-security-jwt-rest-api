package com.example.planner_meditatii.users;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsById(Integer userId);

    void deleteById(Integer userId);
}
