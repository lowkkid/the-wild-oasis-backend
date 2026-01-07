package com.github.lowkkid.thewildoasisbackend.booking.mapper;

import com.github.lowkkid.thewildoasisbackend.booking.domain.entity.Booking;
import com.github.lowkkid.thewildoasisbackend.booking.model.BookingDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingDTO toDto(Booking booking);

    Booking toEntity(BookingDTO bookingDTO);
}

