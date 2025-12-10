package com.github.lowkkid.thewildoasisbackend.domain.repository;

import com.github.lowkkid.thewildoasisbackend.domain.entity.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinRepository extends JpaRepository<Cabin, Long> {
}

