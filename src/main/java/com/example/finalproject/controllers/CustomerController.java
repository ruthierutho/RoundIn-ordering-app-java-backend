package com.example.finalproject.controllers;

import com.example.finalproject.models.Customer;
import com.example.finalproject.models.Order;
import com.example.finalproject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<> (customer, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping(value = "/customers/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        Customer deletedCustomer = customerRepository.getOne(id);
        customerRepository.deleteById(id);
        return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
    }
}
