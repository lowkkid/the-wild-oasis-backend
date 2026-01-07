package com.github.lowkkid.thewildoasisbackend.booking.service;

import com.github.lowkkid.thewildoasisbackend.booking.model.BookingDTO;
import com.github.lowkkid.thewildoasisbackend.booking.model.CheckinRequest;
import com.github.lowkkid.thewildoasisbackend.booking.model.BookingStatus;
import com.github.lowkkid.thewildoasisbackend.booking.model.BookingSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface BookingService {
    Page<BookingSummary> getAll(
            BookingStatus status, Integer pageNumber, Integer pageSize, String sortField, Sort.Direction sortDirection);

    BookingDTO getById(Long id);

    void checkin(Long id, CheckinRequest checkinRequest);

    void checkout(Long id);

    BookingDTO create(BookingDTO bookingDTO);

    BookingDTO update(Long id, BookingDTO bookingDTO);

    void delete(Long id);
}
