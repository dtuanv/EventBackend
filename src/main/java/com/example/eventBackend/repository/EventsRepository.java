package com.example.eventBackend.repository;


import com.example.eventBackend.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer > {
//    @Query(value = )
}
