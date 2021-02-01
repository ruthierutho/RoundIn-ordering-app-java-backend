package com.example.finalproject.controllers;

import com.example.finalproject.models.Customer;
import com.example.finalproject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<> (customer, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customers/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody String newName) {
        Customer customerToUpdate = customerRepository.getOne(id);
        customerToUpdate.setName(newName);
        customerRepository.save(customerToUpdate);
        return new ResponseEntity<>(customerRepository.getOne(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/customers/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        Customer deletedCustomer = customerRepository.getOne(id);
        customerRepository.deleteById(id);
        return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
    }
}
