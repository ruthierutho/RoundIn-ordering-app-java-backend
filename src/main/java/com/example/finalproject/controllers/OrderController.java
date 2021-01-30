package com.example.finalproject.controllers;

import com.example.finalproject.models.Customer;
import com.example.finalproject.models.Order;
import com.example.finalproject.repositories.CustomerRepository;
import com.example.finalproject.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping(value= "/orders")
    public ResponseEntity<List<Order>>getAllOrdersAndFilters(
            @RequestParam(required = false, name = "date") String date
    ) {
        if (date != null){
            return new ResponseEntity<>(orderRepository.findAllByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity getOrders(@PathVariable Long id) {
        return new ResponseEntity<>(orderRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        orderRepository.save(order);
        return new ResponseEntity<> (order, HttpStatus.CREATED);
    }
}

