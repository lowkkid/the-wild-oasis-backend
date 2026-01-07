package com.github.lowkkid.thewildoasisbackend.guest.domain.repository;

import com.github.lowkkid.thewildoasisbackend.guest.domain.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}

