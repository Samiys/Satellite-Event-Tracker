package com.example.sateventtracker.validator;

import com.example.sateventtracker.model.Event;

import java.util.HashMap;
import java.util.Map;

public class EventValidator {
    public static Map<String, String> validateEvent(Event event) {
        Map<String, String> errors = new HashMap<>();

        if (event.getDate() == null) {
            errors.put("date", "Date cannot be null");
        }
        if (event.getDescription() == null || event.getDescription().isEmpty()) {
            errors.put("description", "Description cannot be empty");
        }
        if (event.getPriority() == null || event.getPriority().isEmpty()) {
            errors.put("priority", "Priority cannot be empty");
        }
        if (event.getSatelliteName() == null || event.getSatelliteName().isEmpty()) {
            errors.put("satelliteName", "Satellite name cannot be empty");
        }

        return errors;
    }
}
