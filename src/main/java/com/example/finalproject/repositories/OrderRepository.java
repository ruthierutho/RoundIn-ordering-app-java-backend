package com.example.finalproject.repositories;

import com.example.finalproject.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCollectionDate(String date);
    List<Order> findAllByCollectionTime(String time);
    List<Order> findAllByCollected(Boolean collected);
    List<Order> findAllByVenueIdOrderByCollectionDateAscCollectionTimeAsc(Long id);
}
