package com.github.lowkkid.thewildoasisbackend.mapper;

import com.github.lowkkid.thewildoasisbackend.model.SettingDTO;
import com.github.lowkkid.thewildoasisbackend.domain.entity.Setting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SettingMapper {
    SettingDTO toDto(Setting setting);
    Setting toEntity(SettingDTO settingDTO);
}

