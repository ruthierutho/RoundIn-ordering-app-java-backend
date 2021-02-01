package com.example.finalproject.controllers;

import com.example.finalproject.models.*;
import com.example.finalproject.repositories.CustomerRepository;
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
            @RequestParam(required = false, name = "collected") Boolean collected
    ) {
        if (date != null){
            return new ResponseEntity<>(orderRepository.findAllByDate(date), HttpStatus.OK);
        }
        if (collected != null){
            return new ResponseEntity<>(orderRepository.findAllByCollected(collected), HttpStatus.OK);
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

    @PutMapping(value = "/orders/update/{id}")
    public ResponseEntity updateOrder(
            @PathVariable Long id,
            @RequestBody(required = false) String newDate,
            @RequestBody(required = false) Customer newCustomer,
            @RequestBody(required = false) Venue newVenue,
            @RequestBody(required = false) List<Drink> newDrinks,
            @RequestBody(required = false) List<Food> newFoods,
            @RequestBody(required = false) Boolean collected
    ){
        Order orderToUpdate = orderRepository.getOne(id);
        if (newDate != null) {
            orderToUpdate.setDate(newDate);
        }
        if (newCustomer != null) {
            orderToUpdate.setCustomer(newCustomer);
        }
        if (newVenue != null) {
            orderToUpdate.setVenue(newVenue);
        }
        if (newDrinks != null) {
            orderToUpdate.setDrinks(newDrinks);
        }
        if (newFoods != null) {
            orderToUpdate.setFoods(newFoods);
        }
        if (collected != null) {
            orderToUpdate.setCollected(collected);
        }
        orderRepository.save(orderToUpdate);
        return new ResponseEntity<>(orderRepository.getOne(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/orders/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id) {
        Order deletedOrder = orderRepository.getOne(id);
        orderRepository.deleteById(id);
        return new ResponseEntity<>(deletedOrder, HttpStatus.OK);
    }
}

