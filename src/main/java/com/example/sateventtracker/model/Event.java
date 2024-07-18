package com.example.sateventtracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Date cannot be null")
    private LocalDateTime date;

    @NotEmpty(message = "Description cannot be empty")
    private String description;

    @NotEmpty(message = "Priority cannot be empty")
    private String priority;

    @NotEmpty(message = "Satellite name cannot be empty")
    private String satelliteName;
}
