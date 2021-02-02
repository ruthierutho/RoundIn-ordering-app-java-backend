package com.example.finalproject.controllers;

import com.example.finalproject.models.Drink;
import com.example.finalproject.models.DrinkCategory;
import com.example.finalproject.models.Food;
import com.example.finalproject.models.FoodCategory;
import com.example.finalproject.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class FoodController {

    @Autowired
    FoodRepository foodRepository;

    @GetMapping(value= "/foods")
    public ResponseEntity<List<Food>> getAllDrinksAndFilters(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "price") Double price,
            @RequestParam(required = false, name = "foodCategory")FoodCategory foodCategory
            ) {
        if (name != null){
            return new ResponseEntity<>(foodRepository.findAllByName(name), HttpStatus.OK);
        }
        if (price != null){
            return new ResponseEntity<>(foodRepository.findAllByPrice(price), HttpStatus.OK);
        }
        if (foodCategory != null){
            return new ResponseEntity<>(foodRepository.findAllByFoodCategory(foodCategory), HttpStatus.OK);
        }
        return new ResponseEntity<>(foodRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/foods/{id}")
    public ResponseEntity getFood(@PathVariable Long id) {
        return new ResponseEntity<>(foodRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/foods")
    public ResponseEntity<Food> createDrink(@RequestBody Food food) {
        foodRepository.save(food);
        return new ResponseEntity<> (food, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/foods/{id}")
    public ResponseEntity<Food> updateFood(@RequestBody Food food){
        foodRepository.save(food);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @DeleteMapping(value = "/foods/delete/{id}")
    public ResponseEntity deleteFood(@PathVariable Long id) {
        Food deletedFood = foodRepository.getOne(id);
        foodRepository.deleteById(id);
        return new ResponseEntity<>(deletedFood, HttpStatus.OK);
    }
}
