package com.github.lowkkid.thewildoasisbackend.utils;

import com.github.lowkkid.thewildoasisbackend.model.enums.BookingStatus;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;

public class BookingStatusConverter implements Converter<String, BookingStatus> {
    @Override
    public BookingStatus convert(@NotNull String source) {
        return BookingStatus.fromValue(source);
    }
}
