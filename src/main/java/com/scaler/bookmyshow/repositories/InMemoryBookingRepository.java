package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Booking;

import java.util.HashMap;
import java.util.Map;

public class InMemoryBookingRepository implements BookingRepository {
    private Map<Long, Booking> bookingMap = new HashMap<>();
}
