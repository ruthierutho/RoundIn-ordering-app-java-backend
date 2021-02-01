package com.example.finalproject.repositories;

import com.example.finalproject.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByDate(String date);

    List<Order> findAllByCollected(Boolean collected);
}
