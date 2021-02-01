package com.example.finalproject.repositories;

import com.example.finalproject.models.Drink;
import com.example.finalproject.models.DrinkCategory;
import com.example.finalproject.models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findAllByName(String name);
}
