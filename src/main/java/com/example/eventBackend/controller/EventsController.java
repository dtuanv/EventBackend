package com.example.eventBackend.controller;

import com.example.eventBackend.entity.Events;
import com.example.eventBackend.repository.EventsRepository;
import com.example.eventBackend.service.EventCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Events> getAllEvent(){
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
}
