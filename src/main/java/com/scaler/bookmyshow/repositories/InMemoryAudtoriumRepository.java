package com.scaler.bookmyshow.repositories;


import com.scaler.bookmyshow.models.Auditorium;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAudtoriumRepository implements AuditoriumRepository {
    private Map<Long, Auditorium> auditoriumMap = new HashMap<>();
}
