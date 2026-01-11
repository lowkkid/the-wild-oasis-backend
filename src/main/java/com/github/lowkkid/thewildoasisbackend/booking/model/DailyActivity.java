package com.github.lowkkid.thewildoasisbackend.booking.model;

public record DailyActivity(Long bookingId,
                            BookingStatus status,
                            Short numNights,
                            String guestFullName,
                            String guestCountry) {

}
