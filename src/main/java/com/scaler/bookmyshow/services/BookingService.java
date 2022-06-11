package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.*;
import com.scaler.bookmyshow.repositories.BookingRepository;
import com.scaler.bookmyshow.repositories.InMemoryShowSeatRepository;
import com.scaler.bookmyshow.repositories.ShowSeatRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookingService {
    private BookingRepository bookingRepository ;
    private ShowSeatRepository showSeatRepository;

    public BookingService(BookingRepository bookingRepository,
                          ShowSeatRepository showSeatRepository) {
        this.bookingRepository = bookingRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public Booking createBooking(User user, Show show, List<Long> showSeatsIds) throws Exception {
        // Check if all the showseat are available
        // Block the show seat
        // Create a booking object with status pending
        // Return that object
        List<ShowSeat> currentShowSeats = new ArrayList<>();

//        synchronized (show) {
        boolean didGetAllLocks = true;
        int count = 0;

        List<Long> toBeBookedSeatIds = new ArrayList<>();

        for (Long showSeats: showSeatsIds) {
            toBeBookedSeatIds.add(showSeats);
        }
        Collections.sort(toBeBookedSeatIds);

        // Step 1: Get Lock over all the rows for all the seats to be booked
        for (Long id: toBeBookedSeatIds) {
            boolean didGetLock = showSeatRepository.getLockOverShowSeat(id);
            if (!didGetLock) {
                didGetAllLocks = false;
                break;
            }
            count++;
        }

        // If I am not able to get a lock for even a single of the seats
        //        - unlock all the locks and return exception
        if (!didGetAllLocks) {
            for (int i = 0; i < count; ++i) {
                showSeatRepository.unlockShowSeat(showSeatsIds.get(i));
            }
            throw new Exception("Some seats are unavaiable");
        }

        // Step 3: Fetch the current status of those rows
        for (Long showSeatId: showSeatsIds) {
            currentShowSeats.add(
                    showSeatRepository.getShowSeatById(showSeatId)
            );
        }

        // Step 4: Check if all of those seats are available
        for (ShowSeat currentShowSeat: currentShowSeats) {
            if (!currentShowSeat.getState().equals(ShowSeatState.AVAILABLE)) {
                for (Long showSeatId: showSeatsIds) {
                    showSeatRepository.unlockShowSeat(showSeatId);
                }
                // If any of those seats have state of not available => unlock all seats and throw exception
                throw new Exception("All Seats Not available");
            }
        }

        // Step 5: Mar all of those seats as locked
        for (ShowSeat currentShowSeat: currentShowSeats) {
            currentShowSeat.setState(ShowSeatState.LOCKED);
            showSeatRepository.update(currentShowSeat); // Also update their state in the database
        }

        List<ShowSeatType> showSeatTypes = show.getShowSeatTypes();

        // Create Booking Object
        Booking booking = new Booking();
        booking.setBookedBy(user);
        booking.setShowSeats(currentShowSeats);
        booking.setShow(show);

        double totalAmount = 0;

        for (ShowSeat currentShowSeat: currentShowSeats) {
            for (ShowSeatType showSeatType: showSeatTypes) {
                if (currentShowSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    totalAmount += showSeatType.getPrice();
                }
            }
        }

        // Unlock all the seats
        for (Long id: showSeatsIds) {
            showSeatRepository.unlockShowSeat(id);
        }

        booking.setTotalAmount(totalAmount);
        return booking;
//        }
    }
}

// SHow1 - Seat 1, 2, 3
// Show2 - Seat 4, 5

// Show 1 - Seat 1, 2, 3
// SHow 1 - Seat 7, 8

// I am going to have 1 lock per show seat

// 1 2 3 4
//  4 5 6
// 1 2

// 1 4 2 -> T1 => 1 2 4
// 3 2 5 4 -> T2 => 2 3 4 5
// To ensure atleast one of the thread is able to do the work
// => Taking a lock in a defined order (ascending order)

// T1 -> 1 2 3 4 5
// T2 -> 1
// DOn't be random BUT
// The request that is making a higher number of bookings should be allowed
// [1 s] -> pool all the requests that have come till then and then execute only 1 of them