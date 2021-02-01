package com.example.finalproject.repositories;

import com.example.finalproject.models.Food;
import com.example.finalproject.models.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByName(String name);
    List<Food> findAllByPrice(Double price);
    List<Food> findAllByFoodCategory(FoodCategory foodCategory);
}
