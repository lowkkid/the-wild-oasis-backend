package com.github.lowkkid.thewildoasisbackend.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckinRequest {

    @NotNull
    private Boolean addBreakfast;
    @Min(value = 0, message = "Extras price can not be less than 0")
    private BigDecimal extrasPrice;
    @Min(value = 0, message = "Total price can not be less than 0")
    private BigDecimal totalPrice;
}
