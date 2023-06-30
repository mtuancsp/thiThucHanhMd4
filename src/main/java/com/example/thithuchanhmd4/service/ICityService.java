package com.example.thithuchanhmd4.service;

import com.example.thithuchanhmd4.model.City;
import com.example.thithuchanhmd4.model.Nation;

public interface ICityService extends IGeneralService<City>{
    Iterable<City> findByNation(Nation nation);
}
