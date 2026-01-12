package com.github.lowkkid.lodgecore.guest.domain.repository;

import com.github.lowkkid.lodgecore.guest.domain.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
