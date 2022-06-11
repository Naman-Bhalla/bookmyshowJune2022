package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.ShowSeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostSeatsShowSeatsConcurrencyManagerService implements ShowSeatsConcurrencyManagerService {
    private List<List<Long>> showSeatsRequestCollection = new ArrayList<>();
    private Map<Long, Integer> countOfLockRequestForSeatIds = new HashMap<>();

    @Override
    public boolean getLockForShowSeats(List<Long> showSeatIds) {
        showSeatsRequestCollection.add(showSeatIds);

        // TODO (Implement the logic such that only the request that requested
        // for larger number of seats in case of a conflict gets true

        // 1. For all the seats check if any of them has more than one request

        // 2. If any of the seats has more than one request, check the size of all the requests
        //    asking of it

        return false;
    }
}
