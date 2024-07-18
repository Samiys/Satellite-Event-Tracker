package com.example.sateventtracker.repository;

import com.example.sateventtracker.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findBySatelliteName(String satelliteName);
}