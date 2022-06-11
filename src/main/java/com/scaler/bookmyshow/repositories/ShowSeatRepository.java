package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.ShowSeat;

import java.util.concurrent.locks.Lock;

public interface ShowSeatRepository {

    ShowSeat getShowSeatById(Long id);
    ShowSeat update(ShowSeat showSeat);

    boolean getLockOverShowSeat(Long id);

    void unlockShowSeat(Long id);
}
