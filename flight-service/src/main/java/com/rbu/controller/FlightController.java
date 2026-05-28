package com.rbu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rbu.entity.Flight;
import com.rbu.service.FlightService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService service;
    
    @PostMapping("/save")
    public ResponseEntity<Flight> save(@RequestBody Flight flight) {

        Flight f = service.save(flight);

        return new ResponseEntity<Flight>(f, HttpStatus.CREATED);
    }

    @GetMapping("/find/{code}")
    public ResponseEntity<Flight> findByCode(@PathVariable int code) {

        Flight f = service.findByCode(code);

        return new ResponseEntity<Flight>(f, HttpStatus.OK);
    }

    @GetMapping("/carrier/{carrier}")
    public ResponseEntity<List<Flight>> findByCarrier(@PathVariable String carrier) {
        List<Flight> list = service.findByCarrier(carrier);
        return new ResponseEntity<List<Flight>>(list, HttpStatus.OK);
    }

    @GetMapping("/route")
    public ResponseEntity<List<Flight>> findByRoute(@RequestParam String source,@RequestParam String destination) {
        List<Flight> list = service.findByRoute(source, destination);
        return new ResponseEntity<List<Flight>>(list, HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<List<Flight>> findByPriceRange(
            @RequestParam double min,
            @RequestParam double max) {

        List<Flight> list =
                service.findByPriceRange(min, max);

        return new ResponseEntity<List<Flight>>(list, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Flight>> list() {

        List<Flight> list = service.list();

        return new ResponseEntity<List<Flight>>(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> delete(
            @PathVariable int code) {

        String msg = service.delete(code);

        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
}