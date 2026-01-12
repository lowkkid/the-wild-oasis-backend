package com.github.lowkkid.lodgecore.cabin.domain.repository;

import com.github.lowkkid.lodgecore.cabin.domain.entity.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinRepository extends JpaRepository<Cabin, Long> {
}

