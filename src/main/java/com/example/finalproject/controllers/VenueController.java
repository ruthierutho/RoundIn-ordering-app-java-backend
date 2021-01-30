package com.example.finalproject.controllers;

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
}

//
//    @GetMapping(value = "/customers/{id}")
//    public ResponseEntity getCustomers(@PathVariable Long id) {
//        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/customers")
//    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
//        customerRepository.save(customer);
//        return new ResponseEntity<> (customer, HttpStatus.CREATED);
//    }
//}