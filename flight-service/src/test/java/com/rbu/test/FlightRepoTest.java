package com.rbu.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rbu.entity.Flight;
import com.rbu.repo.FlightRepo;

@DataJpaTest
public class FlightRepoTest {

    @Autowired
    private FlightRepo repo;

    @Test
    public void testSaveFlight() {

        Flight flight =
                new Flight(101, "Indigo", "Nagpur", "Pune", 4500);

        Flight saved = repo.save(flight);

        assertNotNull(saved);
        assertEquals("Indigo", saved.getCarrier());
    }

    @Test
    public void testFindByCarrier() {

        repo.save(new Flight(101, "Indigo", "Nagpur", "Pune", 4500));
        repo.save(new Flight(102, "Indigo", "Mumbai", "Delhi", 7000));

        List<Flight> list = repo.findByCarrier("Indigo");

        assertEquals(2, list.size());
    }

    @Test
    public void testFindByCostBetween() {

        repo.save(new Flight(101, "Indigo", "Nagpur", "Pune", 4500));
        repo.save(new Flight(102, "AirIndia", "Delhi", "Mumbai", 8000));

        List<Flight> list =
                repo.findByCostBetween(4000, 5000);

        assertEquals(1, list.size());
    }
}