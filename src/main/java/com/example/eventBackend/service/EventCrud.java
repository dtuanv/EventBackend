package com.example.eventBackend.service;

import com.example.eventBackend.entity.Events;
import com.example.eventBackend.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventCrud {
    @Autowired
    EventsRepository eventsRepository;
    public Events saveOrUpdate(Events event){
        Events eventUpdate ;
        if(event.getId() >0){
            eventUpdate =   eventsRepository.findById(event.getId())
                    .orElseThrow(() -> new IllegalArgumentException(String.format("Can not found event bY ID: ",event.getId())));
        }else {
            eventUpdate = new Events();
        }
        eventUpdate.setDescription( event.getDescription());
        eventUpdate.setName(event.getName());
        if(event.getLocation() == null){
            return null;
        }else{
            eventUpdate.setLocation(event.getLocation());
        }
        eventUpdate.setCategory(event.getCategory());
        eventUpdate.setDateString(event.getDateString());
        eventUpdate.setImage(event.getImage());

     return    eventsRepository.save(eventUpdate);
    }
    public Events findById(int eventId){
        return eventsRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException(String.format("Can not found Event ID.")));
    }
    public void deleteById(int id){

        eventsRepository.deleteById(id);
    }


    public List<Events> findAll() {
      return   eventsRepository.findAll();
    }
}
