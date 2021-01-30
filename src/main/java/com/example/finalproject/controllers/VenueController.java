package com.example.finalproject.controllers;

import com.example.finalproject.models.Customer;
import com.example.finalproject.models.Venue;
import com.example.finalproject.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VenueController {

    @Autowired
    VenueRepository venueRepository;

    @GetMapping(value= "/venues")
    public ResponseEntity<List<Venue>>getAllVenuesAndFilters(
            @RequestParam(required = false, name = "name") String name
    ) {
        if (name != null){
            return new ResponseEntity<>(venueRepository.findAllByName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(venueRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/venues/{id}")
    public ResponseEntity getVenues(@PathVariable Long id) {
        return new ResponseEntity<>(venueRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/venues")
    public ResponseEntity<Venue> createVenue(@RequestBody Venue venue){
        venueRepository.save(venue);
        return new ResponseEntity<>(venue, HttpStatus.CREATED);
    }
}