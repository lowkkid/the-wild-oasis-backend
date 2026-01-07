package com.github.lowkkid.thewildoasisbackend.setting.service;

import com.github.lowkkid.thewildoasisbackend.setting.model.SettingDTO;

public interface SettingService {
    SettingDTO get();
    SettingDTO update(SettingDTO settingDTO);
}
