package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.CreateBookingRequestDto;
import com.scaler.bookmyshow.dtos.CreateBookingResponseDto;
import com.scaler.bookmyshow.repositories.InMemoryBookingRepository;
import com.scaler.bookmyshow.repositories.InMemoryShowSeatRepository;
import com.scaler.bookmyshow.services.BookingService;

public class BookingController {
    private BookingService bookingService = new BookingService(
            new InMemoryBookingRepository(),
            new InMemoryShowSeatRepository()
    );

    public CreateBookingResponseDto createBooking(
            CreateBookingRequestDto requestDto
    ) {
        return null;
    }
}

// BookMyShow - HLD
// /book
// /seats/{show_id}
// /theatres/{city_id}