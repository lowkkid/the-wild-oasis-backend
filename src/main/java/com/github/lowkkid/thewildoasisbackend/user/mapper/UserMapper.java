package com.github.lowkkid.thewildoasisbackend.user.mapper;

import com.github.lowkkid.thewildoasisbackend.user.domain.entity.User;
import com.github.lowkkid.thewildoasisbackend.user.model.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);
}
