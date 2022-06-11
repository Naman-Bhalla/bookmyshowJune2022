package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.ShowSeat;

import java.util.List;

public interface ShowSeatsConcurrencyManagerService {
    boolean getLockForShowSeats(List<Long> showSeatIds);
}
