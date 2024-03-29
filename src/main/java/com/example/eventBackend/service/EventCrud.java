package com.example.eventBackend.service;

import com.example.eventBackend.entity.Events;
import com.example.eventBackend.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventCrud {

    @Autowired
    EventsRepository eventsRepository;

    public Events saveOrUpdate(Events event) {

        Events eventUpdate;

        if(event.getId() > 0){
            eventUpdate =  eventsRepository.findById(event.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Can not found event by ID: " + event.getId()));
        } else {
            eventUpdate = new Events();
        }
        eventUpdate.setDescription( event.getDescription());
        eventUpdate.setName(event.getName());
        eventUpdate.setCategory(event.getCategory());
        eventUpdate.setDate(event.getDate());
        eventUpdate.setImage(event.getImage());

        if(event.getLocation() == null){
            return null;
        } else {
            eventUpdate.setLocation(event.getLocation());
        }

        if(event.getImage() == null){
            return null;
        }else {
            eventUpdate.setImage(event.getImage());
        }

     return    eventsRepository.save(eventUpdate);
    }

    public Events findById(int eventId){
        return eventsRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Can not found Event ID."));
    }

    public void deleteById(int id){
        eventsRepository.deleteById(id);
    }

    public List<Events> findAll() {
      return   eventsRepository.findAll();
    }

    public List<Events> getEventsByDateRange(LocalDate startDate, LocalDate endDate) {
        return eventsRepository.findByDateBetween(startDate, endDate);
    }

    public List<Events> getEventsByCategory(String category) {
        return eventsRepository.findByCategory(category);
    }

    public List<Events> getEventsByLocation(String location) {
        return eventsRepository.findByLocation(location);
    }
}
