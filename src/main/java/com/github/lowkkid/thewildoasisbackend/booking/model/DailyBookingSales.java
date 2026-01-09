package com.github.lowkkid.thewildoasisbackend.booking.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DailyBookingSales(LocalDateTime date, BigDecimal totalBookingPrice, BigDecimal totalExtrasPrice) {
}
