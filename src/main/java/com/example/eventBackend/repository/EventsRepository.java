package com.example.eventBackend.repository;


import com.example.eventBackend.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer > {

    List<Events> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Events> findByCategory(String category);

    List<Events> findByLocation(String location);
}
