package com.example.eventBackend.service;

import com.example.eventBackend.entity.Events;
import com.example.eventBackend.repository.EventsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase
class EventCrudTest {

    @Autowired
    EventsRepository eventsRepository;
    @Autowired
    EventCrud eventCrud;

    @Test
    void passCategoryWhenSaveOrUpdate() {
        Events event = new Events("Test","08/01/2024", "hAMBURG", "des","img","Music")  ;
        event =  eventCrud.saveOrUpdate(event);

        assertThat(event.getCategory() != null).isTrue();
    }
//    @Test
//    void cannotSaveWhenImageIsNull() {
//        Events eventNoImage = new Events("Test","08/01/2024", "hh", "des",null,"")  ;
//        eventNoLocation =  eventCrud.saveOrUpdate(eventNoImage);
//
//        assertEquals(eventNoImage, null);
//    }

    @Test
    void cannotSaveWhenLocationIsNull() {
        Events eventNoLocation = new Events("Test","08/01/2024", null, "des","img","")  ;
        eventNoLocation =  eventCrud.saveOrUpdate(eventNoLocation);

        assertEquals(eventNoLocation, null);
    }

    @Test
    void testAddEvent() {
        Events event = createAnEvent();
        Events loadEvent = eventsRepository.findById(event.getId()).orElseThrow();
        assertThat(loadEvent).isNotNull();
        assertEquals(event.getId(), loadEvent.getId());
    }

    @Test
    void testUpdateEvent() {
        Events event = createAnEvent();
        Events eventToUpdate = new Events("eventUpdate","14/12/2023","HH","test des","img","");
        eventToUpdate.setId(event.getId());
        eventCrud.saveOrUpdate(eventToUpdate);

        Events loadEvent = eventCrud.findById(event.getId());
        assertEquals("eventUpdate",loadEvent.getName());
        assertEquals("HH",loadEvent.getLocation());
    }

    @Test
    void deleteEvent_Success() {
        Events event = createAnEvent();
        createAnEvent();
        eventCrud.deleteById(event.getId());
      List<Events> loadEvents =  eventCrud.findAll();
      assertThat(loadEvents.stream().anyMatch(e -> e.getId() == event.getId())).isFalse();
    }

    private Events createAnEvent() {
        Events event = new Events("Event test", "14/12/2023", "Hamburg", "test des", "img","");
        event =  eventCrud.saveOrUpdate(event);
        return event;
    }

}