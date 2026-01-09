package com.github.lowkkid.thewildoasisbackend.booking.service;

import com.github.lowkkid.thewildoasisbackend.booking.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {
    Page<BookingSummary> getAll(
            BookingStatus status, Integer pageNumber, Integer pageSize, String sortField, Sort.Direction sortDirection);

    List<DailyBookingSales> getSalesBetweenDates(LocalDateTime start, LocalDateTime end);

    List<StaySummary> getStaySummariesBetweenDates(LocalDateTime start, LocalDateTime end);

    BookingDTO getById(Long id);

    void checkin(Long id, CheckinRequest checkinRequest);

    void checkout(Long id);

    BookingDTO create(BookingDTO bookingDTO);

    BookingDTO update(Long id, BookingDTO bookingDTO);

    void delete(Long id);
}
