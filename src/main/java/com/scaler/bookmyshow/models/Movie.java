package com.scaler.bookmyshow.models;

import java.util.List;

public class Movie {
    private String title;
    private List<Cast> casts;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> cast) {
        this.casts = cast;
    }
}
