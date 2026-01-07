package com.github.lowkkid.thewildoasisbackend.booking.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.github.lowkkid.thewildoasisbackend.cabin.model.CabinDTO;
import com.github.lowkkid.thewildoasisbackend.guest.model.GuestDTO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDTO {
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Short numNights;
    private Short numGuests;
    private BigDecimal cabinPrice;
    private BigDecimal extrasPrice;
    private BigDecimal totalPrice;
    private BookingStatus status;
    private Boolean hasBreakfast;
    private Boolean isPaid;
    private String observations;
    private CabinDTO cabin;
    private GuestDTO guest;
    private LocalDateTime createdAt;

    @JsonGetter("status")
    public String getStatusAsString() {
        return status.toString();
    }
}

