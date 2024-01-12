package com.example.eventBackend.controller;

import com.example.eventBackend.entity.Events;
import com.example.eventBackend.repository.EventsRepository;
import com.example.eventBackend.service.EventCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EventsController {
    @Autowired
    EventsRepository eventsRepository;
    @Autowired
    EventCrud eventCrud;
    @PostMapping("/saveEvent")
    @CrossOrigin
    public void SaveEvents(@RequestBody Events event){
        eventCrud.saveOrUpdate(event);
    }

    @GetMapping("/getEvents")
    @CrossOrigin
    public List<Events> getAllEvents(){
        return eventCrud.findAll();
    }

    @GetMapping("/getEventById/{eventId}")
    @CrossOrigin
    public Events getEventById(@PathVariable int eventId){
        return eventCrud.findById(eventId);
    }

    @DeleteMapping("/deleteEventBy/{eventId}")
    @CrossOrigin
    public void deleteEvent(@PathVariable int eventId){
        eventCrud.deleteById(eventId);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Events>> getEventsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate endDate) {

        List<Events> events = eventCrud.getEventsByDateRange(startDate, endDate);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/by-category")
    public ResponseEntity<List<Events>> getEventsByCategory(@RequestParam String category) {
        List<Events> events = eventCrud.getEventsByCategory(category);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/by-location")
    public ResponseEntity<List<Events>> getEventsByLocation(@RequestParam String location) {
        List<Events> events = eventCrud.getEventsByLocation(location);
        return ResponseEntity.ok(events);
    }
}
