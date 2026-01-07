package com.github.lowkkid.thewildoasisbackend.user.domain.repository;

import com.github.lowkkid.thewildoasisbackend.user.domain.entity.User;
import com.github.lowkkid.thewildoasisbackend.user.model.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

    @Query("SELECT u " +
            "FROM User u " +
            "WHERE (:role IS NULL OR u.role = :role)")
    Page<User> findAllByRole(UserRole role, Pageable pageable);
}
