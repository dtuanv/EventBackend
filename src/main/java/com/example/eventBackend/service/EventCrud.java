package com.example.eventBackend.service;

import com.example.eventBackend.entity.Events;
import com.example.eventBackend.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventCrud {
    @Autowired
    EventsRepository eventsRepository;
    public Events save(Events event){
        Events eventUpdate ;
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

     return    eventsRepository.save(event);
    }


}
