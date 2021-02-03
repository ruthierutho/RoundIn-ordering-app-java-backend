package com.example.finalproject.controllers;

import com.example.finalproject.models.*;
import com.example.finalproject.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;


    @GetMapping(value= "/orders")
    public ResponseEntity<List<Order>>getAllOrdersAndFilters(
            @RequestParam(required = false, name = "date") String date,
            @RequestParam(required = false, name = "time") String time,
            @RequestParam(required = false, name = "collected") Boolean collected
    ) {
        if (date != null){
            return new ResponseEntity<>(orderRepository.findAllByCollectionDate(date), HttpStatus.OK);
        }
        if (time != null){
            return new ResponseEntity<>(orderRepository.findAllByCollectionTime(time), HttpStatus.OK);
        }
        if (collected != null){
            return new ResponseEntity<>(orderRepository.findAllByCollected(collected), HttpStatus.OK);
        }
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity getOrders(@PathVariable Long id) {
        System.out.println("hi");
        return new ResponseEntity<>(orderRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/orders/venue/{id}")
    public ResponseEntity getOrderForVenue(@PathVariable Long id) {
        return new ResponseEntity<>(orderRepository.findAllByVenueIdOrderByCollectionDateAscCollectionTimeAsc(id), HttpStatus.OK);
    }

    @PostMapping(value = "/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        orderRepository.save(order);
        return new ResponseEntity<> (order, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/orders/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        orderRepository.save(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping(value = "/orders/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id) {
        Order deletedOrder = orderRepository.getOne(id);
        orderRepository.deleteById(id);
        return new ResponseEntity<>(deletedOrder, HttpStatus.OK);
    }
}

