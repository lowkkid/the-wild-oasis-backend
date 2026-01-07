package com.github.lowkkid.thewildoasisbackend.guest.mapper;

import com.github.lowkkid.thewildoasisbackend.guest.domain.entity.Guest;
import com.github.lowkkid.thewildoasisbackend.guest.model.GuestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuestMapper {
    GuestDTO toDto(Guest guest);
    Guest toEntity(GuestDTO guestDTO);
}

