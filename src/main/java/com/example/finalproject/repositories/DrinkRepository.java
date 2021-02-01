package com.example.finalproject.repositories;

import com.example.finalproject.models.Drink;
import com.example.finalproject.models.DrinkCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    List<Drink> findAllByName(String name);
    List<Drink> findAllByPrice(Double price);
    List<Drink> findAllByDrinkCategory(DrinkCategory drinkCategory);
}
