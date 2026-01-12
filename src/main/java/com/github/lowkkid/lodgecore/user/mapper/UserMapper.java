package com.github.lowkkid.lodgecore.user.mapper;

import com.github.lowkkid.lodgecore.user.domain.entity.User;
import com.github.lowkkid.lodgecore.user.model.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);
}
