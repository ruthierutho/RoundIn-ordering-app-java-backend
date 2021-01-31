package com.example.finalproject.repositories;

import com.example.finalproject.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
}
