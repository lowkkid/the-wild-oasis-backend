package com.github.lowkkid.lodgecore.common.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Sort;

public class SortDirectionConverter implements Converter<String, Sort.Direction> {
    @Override
    public Sort.Direction convert(@NotNull String source) {
        return Sort.Direction.fromString(source);
    }
}
