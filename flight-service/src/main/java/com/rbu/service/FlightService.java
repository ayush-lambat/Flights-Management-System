package com.rbu.service;
import java.util.List;
import com.rbu.entity.Flight;

public interface FlightService {
    public Flight save(Flight flight);
    public Flight findByCode(int code);
    public List<Flight> findByCarrier(String carrier);
    public List<Flight> findByRoute(String source, String destination);
    public List<Flight> findByPriceRange(double min, double max);
    public List<Flight> list();
    public String delete(int code);
}