package com.github.lowkkid.lodgecore.booking.config;

import com.github.lowkkid.lodgecore.booking.model.BookingStatus;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;

public class BookingStatusConverter implements Converter<String, BookingStatus> {
    @Override
    public BookingStatus convert(@NotNull String source) {
        return BookingStatus.fromValue(source);
    }
}
