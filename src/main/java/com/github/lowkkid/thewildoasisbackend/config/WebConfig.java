package com.github.lowkkid.thewildoasisbackend.config;

import com.github.lowkkid.thewildoasisbackend.utils.BookingStatusConverter;
import com.github.lowkkid.thewildoasisbackend.utils.SortDirectionConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new BookingStatusConverter());
        registry.addConverter(new SortDirectionConverter());
    }
}
