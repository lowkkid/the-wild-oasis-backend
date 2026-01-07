package com.github.lowkkid.thewildoasisbackend.guest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryDto {

    private Long id;
    private String name;
    private String flag;

}
