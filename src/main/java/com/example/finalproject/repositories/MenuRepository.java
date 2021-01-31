package com.example.finalproject.repositories;

import com.example.finalproject.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
