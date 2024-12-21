package com.example.donateapp.service.impl;

import com.example.donateapp.entity.Event;
import com.example.donateapp.repository.EventRepository;
import com.example.donateapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;


    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Event findById(Long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public void update(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void deleteById(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public void deleteAll() {
        eventRepository.deleteAll();
    }
}
