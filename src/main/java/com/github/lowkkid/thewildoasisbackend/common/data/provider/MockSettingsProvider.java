package com.github.lowkkid.thewildoasisbackend.common.data.provider;

import com.github.lowkkid.thewildoasisbackend.setting.domain.entity.Setting;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MockSettingsProvider {

    public static Setting SETTING = Setting.builder()
            .minBookingLength((short) 3)
            .maxBookingLength((short) 90)
            .maxGuestsPerBooking((short) 8)
            .breakfastPrice(new BigDecimal("15.00"))
            .build();
}
