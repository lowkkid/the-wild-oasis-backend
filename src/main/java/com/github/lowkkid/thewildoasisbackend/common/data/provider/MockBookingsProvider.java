package com.github.lowkkid.thewildoasisbackend.common.data.provider;

import com.github.lowkkid.thewildoasisbackend.booking.domain.entity.Booking;
import com.github.lowkkid.thewildoasisbackend.booking.model.BookingStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MockBookingsProvider {
    public static final Booking BOOKING_1 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-06T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-13T00:00:00"))
            .numNights((short) 7)
            .numGuests((short) 1)
            .cabinPrice(new BigDecimal("250.00"))
            .extrasPrice(new BigDecimal("15.00"))
            .totalPrice(new BigDecimal("1765.00"))
            .status(BookingStatus.UNCONFIRMED)
            .hasBreakfast(true)
            .isPaid(false)
            .observations("I have a gluten allergy and would like to request a gluten-free breakfast.")
            .paidAt(null)
            .createdAt(LocalDateTime.parse("2025-11-16T14:30:00"))
            .build();

    public static final Booking BOOKING_2 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-11-13T00:00:00"))
            .endDate(LocalDateTime.parse("2025-11-23T00:00:00"))
            .numNights((short) 10)
            .numGuests((short) 2)
            .cabinPrice(new BigDecimal("250.00"))
            .extrasPrice(new BigDecimal("30.00"))
            .totalPrice(new BigDecimal("2530.00"))
            .status(BookingStatus.CHECKED_OUT)
            .hasBreakfast(true)
            .isPaid(true)
            .observations(null)
            .paidAt(LocalDateTime.parse("2025-11-13T09:00:00"))
            .createdAt(LocalDateTime.parse("2025-11-03T10:15:00"))
            .build();

    public static final Booking BOOKING_3 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-18T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-24T00:00:00"))
            .numNights((short) 6)
            .numGuests((short) 2)
            .cabinPrice(new BigDecimal("250.00"))
            .extrasPrice(BigDecimal.ZERO)
            .totalPrice(new BigDecimal("1500.00"))
            .status(BookingStatus.UNCONFIRMED)
            .hasBreakfast(false)
            .isPaid(true)
            .observations(null)
            .paidAt(LocalDateTime.parse("2025-12-18T10:00:00"))
            .createdAt(LocalDateTime.parse("2025-11-09T16:45:00"))
            .build();

    public static final Booking BOOKING_4 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-10-22T00:00:00"))
            .endDate(LocalDateTime.parse("2025-11-07T00:00:00"))
            .numNights((short) 16)
            .numGuests((short) 2)
            .cabinPrice(new BigDecimal("325.00"))
            .extrasPrice(BigDecimal.ZERO)
            .totalPrice(new BigDecimal("5200.00"))
            .status(BookingStatus.CHECKED_OUT)
            .hasBreakfast(false)
            .isPaid(true)
            .observations(null)
            .paidAt(LocalDateTime.parse("2025-10-22T12:00:00"))
            .createdAt(LocalDateTime.parse("2025-10-22T09:20:00"))
            .build();

    public static final Booking BOOKING_5 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-21T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-24T00:00:00"))
            .numNights((short) 3)
            .numGuests((short) 2)
            .cabinPrice(new BigDecimal("325.00"))
            .extrasPrice(new BigDecimal("30.00"))
            .totalPrice(new BigDecimal("1005.00"))
            .status(BookingStatus.UNCONFIRMED)
            .hasBreakfast(true)
            .isPaid(false)
            .observations(null)
            .paidAt(null)
            .createdAt(LocalDateTime.parse("2025-12-04T18:30:00"))
            .build();

    public static final Booking BOOKING_6 = Booking.builder()
            .startDate(LocalDateTime.parse("2026-01-08T00:00:00"))
            .endDate(LocalDateTime.parse("2026-01-23T00:00:00"))
            .numNights((short) 15)
            .numGuests((short) 2)
            .cabinPrice(new BigDecimal("325.00"))
            .extrasPrice(new BigDecimal("30.00"))
            .totalPrice(new BigDecimal("4905.00"))
            .status(BookingStatus.UNCONFIRMED)
            .hasBreakfast(true)
            .isPaid(false)
            .observations(null)
            .paidAt(null)
            .createdAt(LocalDateTime.parse("2025-12-01T11:45:00"))
            .build();

    public static final Booking BOOKING_7 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-11-11T00:00:00"))
            .endDate(LocalDateTime.parse("2025-11-16T00:00:00"))
            .numNights((short) 5)
            .numGuests((short) 4)
            .cabinPrice(new BigDecimal("300.00"))
            .extrasPrice(new BigDecimal("60.00"))
            .totalPrice(new BigDecimal("1560.00"))
            .status(BookingStatus.CHECKED_OUT)
            .hasBreakfast(true)
            .isPaid(true)
            .observations(null)
            .paidAt(LocalDateTime.parse("2025-11-11T08:00:00"))
            .createdAt(LocalDateTime.parse("2025-10-02T13:10:00"))
            .build();

    public static final Booking BOOKING_8 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-04T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-06T00:00:00"))
            .numNights((short) 2)
            .numGuests((short) 3)
            .cabinPrice(new BigDecimal("300.00"))
            .extrasPrice(BigDecimal.ZERO)
            .totalPrice(new BigDecimal("600.00"))
            .status(BookingStatus.CHECKED_IN)
            .hasBreakfast(false)
            .isPaid(true)
            .observations("We will be bringing our small dog with us")
            .paidAt(LocalDateTime.parse("2025-12-04T09:30:00"))
            .createdAt(LocalDateTime.parse("2025-12-04T20:00:00"))
            .build();

    public static final Booking BOOKING_9 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-11-22T00:00:00"))
            .endDate(LocalDateTime.parse("2025-11-25T00:00:00"))
            .numNights((short) 3)
            .numGuests((short) 4)
            .cabinPrice(new BigDecimal("300.00"))
            .extrasPrice(new BigDecimal("60.00"))
            .totalPrice(new BigDecimal("960.00"))
            .status(BookingStatus.CHECKED_OUT)
            .hasBreakfast(true)
            .isPaid(true)
            .observations(null)
            .paidAt(LocalDateTime.parse("2025-11-22T10:00:00"))
            .createdAt(LocalDateTime.parse("2025-11-22T14:25:00"))
            .build();

    public static final Booking BOOKING_10 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-02T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-14T00:00:00"))
            .numNights((short) 12)
            .numGuests((short) 4)
            .cabinPrice(new BigDecimal("450.00"))
            .extrasPrice(new BigDecimal("60.00"))
            .totalPrice(new BigDecimal("5460.00"))
            .status(BookingStatus.UNCONFIRMED)
            .hasBreakfast(true)
            .isPaid(true)
            .observations(null)
            .paidAt(LocalDateTime.parse("2025-12-02T11:00:00"))
            .createdAt(LocalDateTime.parse("2025-11-06T12:15:00"))
            .build();

    public static final Booking BOOKING_11 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-18T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-23T00:00:00"))
            .numNights((short) 5)
            .numGuests((short) 4)
            .cabinPrice(new BigDecimal("450.00"))
            .extrasPrice(new BigDecimal("60.00"))
            .totalPrice(new BigDecimal("2310.00"))
            .status(BookingStatus.UNCONFIRMED)
            .hasBreakfast(true)
            .isPaid(true)
            .observations(null)
            .paidAt(LocalDateTime.parse("2025-12-18T08:30:00"))
            .createdAt(LocalDateTime.parse("2025-12-05T09:45:00"))
            .build();

    public static final Booking BOOKING_12 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-24T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-25T00:00:00"))
            .numNights((short) 1)
            .numGuests((short) 1)
            .cabinPrice(new BigDecimal("450.00"))
            .extrasPrice(BigDecimal.ZERO)
            .totalPrice(new BigDecimal("450.00"))
            .status(BookingStatus.UNCONFIRMED)
            .hasBreakfast(false)
            .isPaid(true)
            .observations(null)
            .paidAt(LocalDateTime.parse("2025-12-24T14:00:00"))
            .createdAt(LocalDateTime.parse("2025-12-03T17:30:00"))
            .build();

    public static final Booking BOOKING_13 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-20T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-27T00:00:00"))
            .numNights((short) 7)
            .numGuests((short) 5)
            .cabinPrice(new BigDecimal("350.00"))
            .extrasPrice(new BigDecimal("75.00"))
            .totalPrice(new BigDecimal("2525.00"))
            .status(BookingStatus.UNCONFIRMED)
            .hasBreakfast(true)
            .isPaid(false)
            .observations(null)
            .paidAt(null)
            .createdAt(LocalDateTime.parse("2025-12-06T10:00:00"))
            .build();

    public static final Booking BOOKING_14 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-11-30T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-02T00:00:00"))
            .numNights((short) 2)
            .numGuests((short) 4)
            .cabinPrice(new BigDecimal("350.00"))
            .extrasPrice(new BigDecimal("60.00"))
            .totalPrice(new BigDecimal("760.00"))
            .status(BookingStatus.CHECKED_OUT)
            .hasBreakfast(true)
            .isPaid(true)
            .observations(null)
            .paidAt(LocalDateTime.parse("2025-11-30T15:45:00"))
            .createdAt(LocalDateTime.parse("2025-11-30T15:20:00"))
            .build();

    public static final Booking BOOKING_15 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-02T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-05T00:00:00"))
            .numNights((short) 3)
            .numGuests((short) 6)
            .cabinPrice(new BigDecimal("350.00"))
            .extrasPrice(BigDecimal.ZERO)
            .totalPrice(new BigDecimal("1050.00"))
            .status(BookingStatus.CHECKED_OUT)
            .hasBreakfast(false)
            .isPaid(true)
            .observations(null)
            .paidAt(LocalDateTime.parse("2025-12-02T09:00:00"))
            .createdAt(LocalDateTime.parse("2025-12-02T08:45:00"))
            .build();

    public static final Booking BOOKING_16 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-06T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-17T00:00:00"))
            .numNights((short) 11)
            .numGuests((short) 6)
            .cabinPrice(new BigDecimal("700.00"))
            .extrasPrice(BigDecimal.ZERO)
            .totalPrice(new BigDecimal("7700.00"))
            .status(BookingStatus.CHECKED_IN)
            .hasBreakfast(false)
            .isPaid(true)
            .observations("We will be checking in late, around midnight. Hope that's okay :)")
            .paidAt(LocalDateTime.parse("2025-12-06T18:00:00"))
            .createdAt(LocalDateTime.parse("2025-12-03T22:10:00"))
            .build();

    public static final Booking BOOKING_17 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-11-20T00:00:00"))
            .endDate(LocalDateTime.parse("2025-11-27T00:00:00"))
            .numNights((short) 7)
            .numGuests((short) 4)
            .cabinPrice(new BigDecimal("700.00"))
            .extrasPrice(new BigDecimal("60.00"))
            .totalPrice(new BigDecimal("4960.00"))
            .status(BookingStatus.CHECKED_OUT)
            .hasBreakfast(true)
            .isPaid(true)
            .observations("I will need a rollaway bed for one of the guests")
            .paidAt(LocalDateTime.parse("2025-11-20T12:30:00"))
            .createdAt(LocalDateTime.parse("2025-11-20T11:30:00"))
            .build();

    public static final Booking BOOKING_18 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-02T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-05T00:00:00"))
            .numNights((short) 3)
            .numGuests((short) 6)
            .cabinPrice(new BigDecimal("700.00"))
            .extrasPrice(new BigDecimal("90.00"))
            .totalPrice(new BigDecimal("2190.00"))
            .status(BookingStatus.CHECKED_OUT)
            .hasBreakfast(true)
            .isPaid(true)
            .observations(null)
            .paidAt(LocalDateTime.parse("2025-12-02T10:00:00"))
            .createdAt(LocalDateTime.parse("2025-11-18T16:50:00"))
            .build();

    public static final Booking BOOKING_19 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-23T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-29T00:00:00"))
            .numNights((short) 6)
            .numGuests((short) 8)
            .cabinPrice(new BigDecimal("500.00"))
            .extrasPrice(BigDecimal.ZERO)
            .totalPrice(new BigDecimal("3000.00"))
            .status(BookingStatus.UNCONFIRMED)
            .hasBreakfast(false)
            .isPaid(false)
            .observations(null)
            .paidAt(null)
            .createdAt(LocalDateTime.parse("2025-12-04T19:15:00"))
            .build();

    public static final Booking BOOKING_20 = Booking.builder()
            .startDate(LocalDateTime.parse("2026-01-15T00:00:00"))
            .endDate(LocalDateTime.parse("2026-01-25T00:00:00"))
            .numNights((short) 10)
            .numGuests((short) 7)
            .cabinPrice(new BigDecimal("500.00"))
            .extrasPrice(new BigDecimal("105.00"))
            .totalPrice(new BigDecimal("5105.00"))
            .status(BookingStatus.UNCONFIRMED)
            .hasBreakfast(true)
            .isPaid(true)
            .observations(null)
            .paidAt(LocalDateTime.parse("2026-01-15T09:00:00"))
            .createdAt(LocalDateTime.parse("2025-11-29T13:40:00"))
            .build();

    public static final Booking BOOKING_21 = Booking.builder()
            .startDate(LocalDateTime.parse("2026-01-07T00:00:00"))
            .endDate(LocalDateTime.parse("2026-01-12T00:00:00"))
            .numNights((short) 5)
            .numGuests((short) 6)
            .cabinPrice(new BigDecimal("500.00"))
            .extrasPrice(new BigDecimal("90.00"))
            .totalPrice(new BigDecimal("2590.00"))
            .status(BookingStatus.UNCONFIRMED)
            .hasBreakfast(true)
            .isPaid(true)
            .observations(null)
            .paidAt(LocalDateTime.parse("2026-01-07T11:00:00"))
            .createdAt(LocalDateTime.parse("2025-10-12T10:25:00"))
            .build();

    public static final Booking BOOKING_22 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-01T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-06T00:00:00"))
            .numNights((short) 5)
            .numGuests((short) 9)
            .cabinPrice(new BigDecimal("1400.00"))
            .extrasPrice(new BigDecimal("135.00"))
            .totalPrice(new BigDecimal("7135.00"))
            .status(BookingStatus.CHECKED_IN)
            .hasBreakfast(true)
            .isPaid(true)
            .observations("My wife has a gluten allergy so I would like to request a gluten-free breakfast if possible")
            .paidAt(LocalDateTime.parse("2025-12-01T10:30:00"))
            .createdAt(LocalDateTime.parse("2025-11-28T08:30:00"))
            .build();

    public static final Booking BOOKING_23 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-06T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-11T00:00:00"))
            .numNights((short) 5)
            .numGuests((short) 10)
            .cabinPrice(new BigDecimal("1400.00"))
            .extrasPrice(new BigDecimal("150.00"))
            .totalPrice(new BigDecimal("7150.00"))
            .status(BookingStatus.CHECKED_IN)
            .hasBreakfast(true)
            .isPaid(true)
            .observations("I am celebrating my anniversary, can you arrange for any special amenities or decorations?")
            .paidAt(LocalDateTime.parse("2025-12-06T13:00:00"))
            .createdAt(LocalDateTime.parse("2025-12-06T12:00:00"))
            .build();

    public static final Booking BOOKING_24 = Booking.builder()
            .startDate(LocalDateTime.parse("2025-12-16T00:00:00"))
            .endDate(LocalDateTime.parse("2025-12-19T00:00:00"))
            .numNights((short) 3)
            .numGuests((short) 7)
            .cabinPrice(new BigDecimal("1400.00"))
            .extrasPrice(BigDecimal.ZERO)
            .totalPrice(new BigDecimal("4200.00"))
            .status(BookingStatus.UNCONFIRMED)
            .hasBreakfast(false)
            .isPaid(false)
            .observations(null)
            .paidAt(null)
            .createdAt(LocalDateTime.parse("2025-11-26T14:15:00"))
            .build();

    public static final List<Booking> ALL_BOOKINGS = Arrays.asList(
            BOOKING_1,
            BOOKING_2,
            BOOKING_3,
            BOOKING_4,
            BOOKING_5,
            BOOKING_6,
            BOOKING_7,
            BOOKING_8,
            BOOKING_9,
            BOOKING_10,
            BOOKING_11,
            BOOKING_12,
            BOOKING_13,
            BOOKING_14,
            BOOKING_15,
            BOOKING_16,
            BOOKING_17,
            BOOKING_18,
            BOOKING_19,
            BOOKING_20,
            BOOKING_21,
            BOOKING_22,
            BOOKING_23,
            BOOKING_24
    );
}