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
    void testAddEvent() {
        Events event = createAnEvent();
        Events loadEvent = eventsRepository.findById(event.getId()).orElseThrow();
        assertThat(loadEvent).isNotNull();
        assertEquals(event.getId(), loadEvent.getId());
    }

    @Test
    void testUpdateEvent() {
        Events event = createAnEvent();
        Events eventToUpdate = new Events("eventUpdate","14/12/2023","HH","test des","img");
        eventToUpdate.setId(event.getId());
        eventCrud.saveOrUpdate(eventToUpdate);

        Events loadEvent = eventCrud.findById(event.getId());
        assertEquals("eventUpdate",loadEvent.getName());
        assertEquals("HH",loadEvent.getLocation());
    }

    @Test
    void deleteEvent_Success() {
        Events event = createAnEvent();
        Events event2 = createAnEvent();
        List<Events> loadEvents2 =  eventCrud.findAll();

        eventCrud.deleteById(event.getId());
      List<Events> loadEvents =  eventCrud.findAll();
      assertThat(loadEvents.stream().anyMatch(e -> e.getId() == event.getId())).isFalse();
    }

    private Events createAnEvent() {
        Events event = new Events("Event test", "14/12/2023", "Hamburg", "test des", "img");
        event =  eventCrud.saveOrUpdate(event);
        return event;
    }

}