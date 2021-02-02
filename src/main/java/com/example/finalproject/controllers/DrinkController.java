package com.example.finalproject.controllers;

import com.example.finalproject.models.Drink;
import com.example.finalproject.models.DrinkCategory;
import com.example.finalproject.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DrinkController {

    @Autowired
    DrinkRepository drinkRepository;

    @GetMapping(value= "/drinks")
    public ResponseEntity<List<Drink>> getAllDrinksAndFilters(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "price") Double price,
            @RequestParam(required = false, name = "drinkCategory")DrinkCategory drinkCategory
            ) {
        if (name != null){
            return new ResponseEntity<>(drinkRepository.findAllByName(name), HttpStatus.OK);
        }
        if (price != null){
            return new ResponseEntity<>(drinkRepository.findAllByPrice(price), HttpStatus.OK);
        }
        if (drinkCategory != null){
            return new ResponseEntity<>(drinkRepository.findAllByDrinkCategory(drinkCategory), HttpStatus.OK);
        }
        return new ResponseEntity<>(drinkRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/drinks/{id}")
    public ResponseEntity getDrink(@PathVariable Long id) {
        return new ResponseEntity<>(drinkRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/drinks")
    public ResponseEntity<Drink> createDrink(@RequestBody Drink drink) {
        drinkRepository.save(drink);
        return new ResponseEntity<> (drink, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/drinks/{id}")
    public ResponseEntity<Drink> updateDrink(@RequestBody Drink drink){
        drinkRepository.save(drink);
        return new ResponseEntity<>(drink, HttpStatus.OK);
    }

    @DeleteMapping(value = "/drinks/delete/{id}")
    public ResponseEntity deleteDrink(@PathVariable Long id) {
        Drink deletedDrink = drinkRepository.getOne(id);
        drinkRepository.deleteById(id);
        return new ResponseEntity<>(deletedDrink, HttpStatus.OK);
    }
}
