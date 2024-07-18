package com.example.sateventtracker.service;

import com.example.sateventtracker.model.Event;
import com.example.sateventtracker.repository.EventRepository;
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

    public List<Event> getEventBySatelliteName(String satelliteName) {
        return eventRepository.findBySatelliteName(satelliteName);
    }

}
