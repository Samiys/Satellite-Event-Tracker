package com.example.sateventtracker;

import com.example.sateventtracker.model.Event;
import com.example.sateventtracker.repository.EventRepository;
import com.example.sateventtracker.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
}
