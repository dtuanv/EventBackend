package com.example.eventBackend.controller;

import com.example.eventBackend.entity.Events;
import com.example.eventBackend.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {
    @Autowired
    EventsRepository eventsRepository;
    @PostMapping("/saveEvent")
    public void SaveEvents(@RequestBody Events events){

        System.out.println("moin");
        eventsRepository.save(events);
    }
    @GetMapping("/getEvent")
    public String getEvent(){
        return "Moin";
    }
}
