package com.example.sateventtracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println("Controller received request to find event by satelliteName: " + satelliteName);
        List<Event> events = eventService.getEventBySatelliteName(satelliteName);
        if (!events.isEmpty()) {
            return ResponseEntity.ok(events);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
