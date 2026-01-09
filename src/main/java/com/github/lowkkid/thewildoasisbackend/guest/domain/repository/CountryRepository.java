package com.github.lowkkid.thewildoasisbackend.guest.domain.repository;

import com.github.lowkkid.thewildoasisbackend.guest.domain.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
