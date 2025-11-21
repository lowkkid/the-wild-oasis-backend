package com.github.lowkkid.thewildoasisbackend.service;

import com.github.lowkkid.thewildoasisbackend.dto.SettingDTO;

import java.util.List;

public interface SettingService {
    List<SettingDTO> getAll();
    SettingDTO getById(Long id);
    SettingDTO create(SettingDTO settingDTO);
    SettingDTO update(Long id, SettingDTO settingDTO);
    void delete(Long id);
}
