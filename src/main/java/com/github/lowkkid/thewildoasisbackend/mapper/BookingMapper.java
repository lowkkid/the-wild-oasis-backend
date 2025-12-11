package com.github.lowkkid.thewildoasisbackend.mapper;

import com.github.lowkkid.thewildoasisbackend.model.BookingDTO;
import com.github.lowkkid.thewildoasisbackend.domain.entity.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingDTO toDto(Booking booking);

    Booking toEntity(BookingDTO bookingDTO);
}

