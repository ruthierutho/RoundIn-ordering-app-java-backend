package com.example.finalproject.controllers;

import com.example.finalproject.models.Customer;
import com.example.finalproject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value= "/customers")
    public ResponseEntity<List<Customer>>getAllCustomersAndFilters(
            @RequestParam(required = false, name = "name") String name
    ) {
        if (name != null){
            return new ResponseEntity<>(customerRepository.findAllByName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

//    @GetMapping(value = "/customers/{id}")
//    public ResponseEntity getCustomers(@PathVariable Long id) {
//        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
//    }
}
