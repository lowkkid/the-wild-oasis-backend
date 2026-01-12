package com.github.lowkkid.lodgecore.booking.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum BookingStatus {

    CHECKED_IN("checked-in"),
    CHECKED_OUT("checked-out"),
    UNCONFIRMED("unconfirmed");

    private final String value;

    @Override
    public String toString() {
        return value;
    }

    public static BookingStatus fromValue(String value) {
        for (BookingStatus status : values()) {
            if (value.equals(status.value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid booking status value: " + value);
    }
}
