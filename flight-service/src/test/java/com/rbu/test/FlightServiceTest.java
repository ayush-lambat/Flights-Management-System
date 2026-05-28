package com.rbu.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rbu.entity.Flight;
import com.rbu.repo.FlightRepo;
import com.rbu.service.FlightServiceImpl;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {

    @Mock
    private FlightRepo repo;

    @InjectMocks
    private FlightServiceImpl service;

    @Test
    public void testSaveFlight() {

        Flight flight =
                new Flight(101, "Indigo", "Nagpur", "Pune", 4500);

        when(repo.save(flight)).thenReturn(flight);

        Flight result = service.save(flight);

        assertNotNull(result);
        assertEquals("Indigo", result.getCarrier());
    }

    @Test
    public void testFindByCode() {

        Flight flight =
                new Flight(101, "Indigo", "Nagpur", "Pune", 4500);

        when(repo.findById(101))
                .thenReturn(Optional.of(flight));

        Flight result = service.findByCode(101);

        assertEquals("Pune", result.getDestination());
    }

    @Test
    public void testFindByCarrier() {

        List<Flight> list = Arrays.asList(
                new Flight(101, "Indigo", "Nagpur", "Pune", 4500),
                new Flight(102, "Indigo", "Mumbai", "Delhi", 7000)
        );

        when(repo.findByCarrier("Indigo"))
                .thenReturn(list);

        List<Flight> result = service.findByCarrier("Indigo");

        assertEquals(2, result.size());
    }

    @Test
    public void testListAllFlights() {

        List<Flight> list = Arrays.asList(
                new Flight(101, "Indigo", "Nagpur", "Pune", 4500),
                new Flight(102, "AirIndia", "Delhi", "Mumbai", 6500)
        );

        when(repo.findAll()).thenReturn(list);

        List<Flight> result = service.list();

        assertEquals(2, result.size());
    }
}