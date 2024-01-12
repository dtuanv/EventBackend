package com.example.eventBackend.service;

import com.example.eventBackend.entity.Events;
import com.example.eventBackend.repository.EventsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@AutoConfigureTestDatabase
class EventCrudTest {

    @Autowired
    EventsRepository eventsRepository;
    @Autowired
    EventCrud eventCrud;

    @Test
    void passCategoryWhenSaveOrUpdate() {
        Events event = new Events("Test", LocalDate.of(2024, 1, 18), "HAMBURG", "des","img","Music")  ;
        event =  eventCrud.saveOrUpdate(event);

        assertThat(event.getCategory() != null).isTrue();
    }
//    @Test
//    void cannotSaveWhenImageIsNull() {
//        Events eventNoImage = new Events("Test", LocalDate.of(2024, 1, 18), "hh", "des",null,"")  ;
//        eventNoLocation =  eventCrud.saveOrUpdate(eventNoImage);
//
//        assertEquals(eventNoImage, null);
//    }

    @Test
    void cannotSaveWhenLocationIsNull() {
        Events eventNoLocation = new Events("Mocky", LocalDate.of(2024, 1, 18), null, "des","img","")  ;
        eventNoLocation =  eventCrud.saveOrUpdate(eventNoLocation);

        assertNull(eventNoLocation);
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
        Events eventToUpdate = new Events("eventUpdate", LocalDate.of(2024, 1, 18),"HH","test des","img","");
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
        Events event = new Events("Event test", LocalDate.of(2024, 1, 18), "Hamburg", "test des", "img","");
        event =  eventCrud.saveOrUpdate(event);
        return event;
    }

}