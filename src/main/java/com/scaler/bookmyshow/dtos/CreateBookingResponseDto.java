package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.models.Booking;

public class CreateBookingResponseDto {
    private Booking booking;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
