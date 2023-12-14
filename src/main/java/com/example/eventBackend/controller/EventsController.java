package com.example.eventBackend.controller;

import com.example.eventBackend.entity.Events;
import com.example.eventBackend.repository.EventsRepository;
import com.example.eventBackend.service.EventCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class EventsController {
    @Autowired
    EventsRepository eventsRepository;
    @Autowired
    EventCrud eventCrud;
    @PostMapping("/saveEvent")
    @CrossOrigin
    public void SaveEvents(@RequestBody Events event){
        eventCrud.save(event);
    }
    @GetMapping("/getEvents")
    @CrossOrigin
    public List<Events> getAllEvent(){


        return eventsRepository.findAll();
    }

    @GetMapping("/getEventById/{eventId}")
    @CrossOrigin
    public Events getAllEventById(@PathVariable int eventId){


        return eventsRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException(String.format("Can not found Event ID.")));
    }

    @DeleteMapping("/deleteEventBy/{eventId}")
    @CrossOrigin
    public void deleteEvent(@PathVariable int eventId){

         eventsRepository.deleteById(eventId);
    }
}
