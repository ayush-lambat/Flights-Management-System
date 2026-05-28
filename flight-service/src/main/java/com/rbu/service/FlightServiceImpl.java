package com.rbu.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbu.entity.Flight;
import com.rbu.exception.FlightNotFoundException;
import com.rbu.repo.FlightRepo;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepo repo;
    @Override
    public Flight save(Flight flight) {
        return repo.save(flight);
    }
    @Override
    public Flight findByCode(int code) {

        return repo.findById(code).orElseThrow(() -> new FlightNotFoundException("Flight Not Found"));
    }
    @Override
    public List<Flight> findByCarrier(String carrier) {
        return repo.findByCarrier(carrier);
    }
    @Override
    public List<Flight> findByRoute(String source, String destination) {
        return repo.findBySourceAndDestination(source, destination);
    }
    @Override
    public List<Flight> findByPriceRange(double min, double max) {
        return repo.findByCostBetween(min, max);
    }
    @Override
    public List<Flight> list() {
        return repo.findAll();
    }

    @Override
    public String delete(int code) {
        Flight flight = repo.findById(code).orElseThrow(() -> new FlightNotFoundException("Flight Not Found"));
        repo.delete(flight);
        return "Flight Deleted Successfully";
    }
}