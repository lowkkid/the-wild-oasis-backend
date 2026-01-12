package com.github.lowkkid.lodgecore.booking.domain.entity;

import com.github.lowkkid.lodgecore.booking.model.BookingStatus;
import com.github.lowkkid.lodgecore.cabin.domain.entity.Cabin;
import com.github.lowkkid.lodgecore.common.domain.entity.Tracked;
import com.github.lowkkid.lodgecore.guest.domain.entity.Guest;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Booking extends Tracked {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "num_nights", nullable = false)
    private Short numNights;

    @Column(name = "num_guests", nullable = false)
    private Short numGuests;

    @Column(name = "cabin_price", nullable = false)
    private BigDecimal cabinPrice;

    @Column(name = "extras_price", nullable = false)
    @Builder.Default
    private BigDecimal extrasPrice = BigDecimal.ZERO;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @Column(name = "has_breakfast", nullable = false)
    private Boolean hasBreakfast;

    @Column(name = "is_paid", nullable = false)
    private Boolean isPaid;

    @Column(name = "paid_at")
    private LocalDateTime paidAt;

    @Column(name = "observations")
    private String observations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cabin_id", nullable = false)
    private Cabin cabin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;
}
