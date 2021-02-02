package com.example.finalproject.repositories;

import com.example.finalproject.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCollectionDate(LocalDate date);
    List<Order> findAllByCollectionTime(LocalTime time);

    List<Order> findAllByCollected(Boolean collected);

    List<Order> findAllByOrderByCollectionDateAsc();
    List<Order> findAllByOrderByCollectionDateAscCollectionTimeAsc();
}
