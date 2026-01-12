package com.github.lowkkid.lodgecore.setting.domain.repository;

import com.github.lowkkid.lodgecore.setting.domain.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {
}

