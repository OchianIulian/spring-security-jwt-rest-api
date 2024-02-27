package com.example.planner_meditatii.mails.token;

import com.example.planner_meditatii.users.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Clasa model pentru tokenul de confirmare
 */
@Data
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime localDateTime;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "user_id"
    )
    private User user;



    public ConfirmationToken(String token,
                             LocalDateTime localDateTime,
                             LocalDateTime expiresAt,
                             User user) {
        this.token = token;
        this.localDateTime = localDateTime;
        this.expiresAt = expiresAt;
        this.user = user;
    }
}
