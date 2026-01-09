package com.github.lowkkid.thewildoasisbackend.setting.domain.entity;

import com.github.lowkkid.thewildoasisbackend.common.domain.entity.Tracked;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Setting extends Tracked {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "min_booking_length", nullable = false)
    private Short minBookingLength;

    @Column(name = "max_booking_length", nullable = false)
    private Short maxBookingLength;

    @Column(name = "max_guests_per_booking", nullable = false)
    private Short maxGuestsPerBooking;

    @Column(name = "breakfast_price", nullable = false)
    private BigDecimal breakfastPrice;
}

