package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.models.User;

import java.util.List;

public class CreateBookingRequestDto {
    private Show show;
    private List<Long> showSeatsIds;
    private User user;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Long> getShowSeats() {
        return showSeatsIds;
    }

    public void setShowSeats(List<Long> showSeatIds) {
        this.showSeatsIds = showSeatIds;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
