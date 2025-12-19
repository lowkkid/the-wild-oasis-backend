package com.github.lowkkid.thewildoasisbackend.security.mapper;

import com.github.lowkkid.thewildoasisbackend.domain.entity.User;
import com.github.lowkkid.thewildoasisbackend.security.model.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);
}
