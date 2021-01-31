package com.example.finalproject.repositories;

import com.example.finalproject.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
