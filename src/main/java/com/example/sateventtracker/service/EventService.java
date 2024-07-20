package com.example.sateventtracker.service;

import com.example.sateventtracker.model.Event;
import com.example.sateventtracker.repository.EventRepository;
import com.example.sateventtracker.exception.EventNotFoundException;
import com.example.sateventtracker.validator.EventValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        Map<String, String> errors = EventValidator.validateEvent(event);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Validation failed: " + errors.toString());
        }
        return eventRepository.save(event);
    }

    public List<Event> getEventsBySatelliteName(String satelliteName) {
        List<Event> events = eventRepository.findBySatelliteName(satelliteName);
        if (events.isEmpty()) {
            throw new EventNotFoundException("No events found for satellite name: " + satelliteName);
        }
        return events;
    }

    public List<Event> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        if (events.isEmpty()) {
            throw new EventNotFoundException("No events found");
        }
        return events;
    }
}
