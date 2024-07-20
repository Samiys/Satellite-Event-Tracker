package com.example.sateventtracker;

import com.example.sateventtracker.model.Event;
import com.example.sateventtracker.repository.EventRepository;
import com.example.sateventtracker.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EventServiceTest {
    @Mock
    private EventRepository eventRepository;

    private EventService eventService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        eventService = new EventService(eventRepository);
    }

    @Test
    void testCreateEvent() {
        Event event = new Event();
        event.setDate(LocalDateTime.now());
        event.setDescription("Test Event");
        event.setPriority("High");
        event.setSatelliteName("SENTINEL-1A");

        when(eventRepository.save(any(Event.class))).thenReturn(event);

        Event createdEvent = eventService.createEvent(event);
        assertNotNull(createdEvent);
    }

    @Test
    void testCreateEventWithMissingFields() {
        Event event = new Event();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            eventService.createEvent(event);
        });
        String actualMessage = exception.getMessage();
        Map<String, String> expectedErrors = new HashMap<>();
        expectedErrors.put("description", "Description cannot be empty");
        expectedErrors.put("priority", "Priority cannot be empty");
        expectedErrors.put("satelliteName", "Satellite name cannot be empty");
        expectedErrors.forEach((key, value) -> assertTrue(actualMessage.contains(key + "=" + value)));
    }

    @Test
    void testGetEventsBySatelliteName() {
        Event event = new Event();
        event.setDate(LocalDateTime.now());
        event.setDescription("Test Event");
        event.setPriority("High");
        event.setSatelliteName("SENTINEL-1A");

        when(eventRepository.findBySatelliteName("SENTINEL-1A")).thenReturn(List.of(event));

        List<Event> events = eventService.getEventsBySatelliteName("SENTINEL-1A");
        assertFalse(events.isEmpty());
        assertEquals("SENTINEL-1A", events.get(0).getSatelliteName());
    }

    @Test
    void testGetAllEvents() {
        Event event1 = new Event();
        event1.setDate(LocalDateTime.now());
        event1.setDescription("Test Event 1");
        event1.setPriority("High");
        event1.setSatelliteName("SAT-1");

        Event event2 = new Event();
        event2.setDate(LocalDateTime.now());
        event2.setDescription("Test Event 2");
        event2.setPriority("Low");
        event2.setSatelliteName("SAT-2");

        when(eventRepository.findAll()).thenReturn(List.of(event1, event2));

        List<Event> events = eventService.getAllEvents();
        assertEquals(2, events.size());
    }
}
