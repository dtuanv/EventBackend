package com.example.eventBackend.controller;

import com.example.eventBackend.entity.Events;
import com.example.eventBackend.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class EventsController {
    @Autowired
    EventsRepository eventsRepository;
    @PostMapping("/saveEvent")
    @CrossOrigin
    public void SaveEvents(@RequestBody Events event){
        Events eventUpdate ;
        System.out.println("moin, "+event.getId());
        if(event.getId() >0){
         eventUpdate =   eventsRepository.findById(event.getId())
                 .orElseThrow(() -> new IllegalArgumentException(String.format("Can not found event bY ID: ",event.getId())));
        }else {
            eventUpdate = new Events();
        }
        eventUpdate.setDescription( event.getDescription());
        eventUpdate.setName(event.getName());
        eventUpdate.setLocation(event.getLocation());
        eventUpdate.setDateString(event.getDateString());
        eventUpdate.setImage(event.getImage());

        eventsRepository.save(event);
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
}
