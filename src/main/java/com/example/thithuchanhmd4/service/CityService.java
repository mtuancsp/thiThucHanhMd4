package com.example.thithuchanhmd4.service;

import com.example.thithuchanhmd4.model.City;
import com.example.thithuchanhmd4.model.Nation;
import com.example.thithuchanhmd4.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService{

    @Autowired
    private ICityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public City save(City t) {
        return cityRepository.save(t);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public Iterable<City> findByNation(Nation nation) {
        return cityRepository.findAllByNation(nation);
    }
}
