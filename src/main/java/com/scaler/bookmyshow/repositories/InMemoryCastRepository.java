package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Cast;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCastRepository implements CastRepository {
    private Map<Long, Cast> castMap = new HashMap<>();
}
