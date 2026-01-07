package com.github.lowkkid.thewildoasisbackend.booking.config;

import com.github.lowkkid.thewildoasisbackend.booking.model.BookingStatus;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;

public class BookingStatusConverter implements Converter<String, BookingStatus> {
    @Override
    public BookingStatus convert(@NotNull String source) {
        return BookingStatus.fromValue(source);
    }
}
