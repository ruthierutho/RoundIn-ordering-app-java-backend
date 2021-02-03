package com.example.finalproject.repositories;

import com.example.finalproject.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findAllByName(String name);

    List<Menu> findAllByVenuesId(Long id);
}
