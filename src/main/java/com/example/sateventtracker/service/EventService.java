package com.example.sateventtracker.service;

import com.example.sateventtracker.model.Event;
import com.example.sateventtracker.repository.EventRepository;
import exception.EventNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
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
