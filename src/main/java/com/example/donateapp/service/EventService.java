package com.example.donateapp.service;

import com.example.donateapp.entity.Event;

import java.util.List;

public interface EventService {
    void save(Event event);

    Event findById(Long eventId);

    List<Event> findAll();

    void update(Event event);

    void deleteById(Long eventId);

    void deleteAll();
}
