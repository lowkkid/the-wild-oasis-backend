package com.github.lowkkid.lodgecore.user.domain.entity;

import com.github.lowkkid.lodgecore.common.domain.entity.Tracked;
import com.github.lowkkid.lodgecore.user.model.UserRole;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@Table(name = "users")
public class User extends Tracked {

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
}
