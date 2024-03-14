package com.example.planner_meditatii.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;
    @Test
    void findByEmail() {
    }

    @Test
    void existsById() {
    }

    @Test
    void itShouldCheckIfUserExistsByEmil() {

        //given
        User user = new User("Andrei", "Ochian", "ochian_a@gmail.con", "password", Role.USER);
        underTest.save(user);
        //when
        boolean exists = underTest.existsByEmil(user.getEmail());
        //then
        assertThat(exists).isTrue();
    }

    @Test
    void deleteById() {
    }

    @Test
    void enableUser() {
    }
}