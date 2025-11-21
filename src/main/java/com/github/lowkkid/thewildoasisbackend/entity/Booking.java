package com.github.lowkkid.thewildoasisbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

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

    @Column(name = "cabin_price", nullable = false, precision = 7, scale = 2)
    private BigDecimal cabinPrice;

    @Column(name = "extras_price", nullable = false, precision = 7, scale = 2)
    @Builder.Default
    private BigDecimal extrasPrice = BigDecimal.ZERO;

    @Column(name = "total_price", nullable = false, precision = 7, scale = 2)
    private BigDecimal totalPrice;

    @Column(nullable = false, length = 255)
    private String status;

    @Column(name = "has_breakfast", nullable = false)
    private Boolean hasBreakfast;

    @Column(name = "is_paid", nullable = false)
    private Boolean isPaid;

    @Column(columnDefinition = "TEXT")
    private String observations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cabin_id", nullable = false, foreignKey = @ForeignKey(name = "fk_bookings_cabin"))
    private Cabin cabin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id", nullable = false, foreignKey = @ForeignKey(name = "fk_bookings_guest"))
    private Guest guest;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
