package com.github.lowkkid.thewildoasisbackend.user.domain.entity;

import com.github.lowkkid.thewildoasisbackend.user.model.UserRole;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
