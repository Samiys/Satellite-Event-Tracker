package com.example.sateventtracker.controller;

import com.example.sateventtracker.model.Event;
import com.example.sateventtracker.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @GetMapping("/findBySatelliteName")
    public ResponseEntity<List<Event>> getEventBySatelliteName(@RequestParam String satelliteName) {
        List<Event> events = eventService.getEventsBySatelliteName(satelliteName);
        return ResponseEntity.ok(events);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }
}
