package com.example.finalproject.repositories;

import com.example.finalproject.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    List<Venue> findAllByName(String name);
}
