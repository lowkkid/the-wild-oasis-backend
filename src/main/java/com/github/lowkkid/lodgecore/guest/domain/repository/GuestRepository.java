package com.github.lowkkid.lodgecore.guest.domain.repository;

import com.github.lowkkid.lodgecore.guest.domain.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}

