package com.github.lowkkid.thewildoasisbackend.setting.mapper;

import com.github.lowkkid.thewildoasisbackend.setting.model.SettingDTO;
import com.github.lowkkid.thewildoasisbackend.setting.domain.entity.Setting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SettingMapper {
    SettingDTO toDto(Setting setting);
    Setting toEntity(SettingDTO settingDTO);
}

