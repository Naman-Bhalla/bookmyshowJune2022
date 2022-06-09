package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.City;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCityRepository implements CityRepository {
    private Map<Long, City> cityMap = new HashMap<>();
}
