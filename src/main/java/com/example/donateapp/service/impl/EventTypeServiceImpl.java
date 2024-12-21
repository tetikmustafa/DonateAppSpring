package com.example.donateapp.service.impl;

import com.example.donateapp.entity.EventType;
import com.example.donateapp.repository.EventTypeRepository;
import com.example.donateapp.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventTypeServiceImpl implements EventTypeService {

    @Autowired
    EventTypeRepository eventTypeRepository;

    @Override
    public EventType findById(Long id) {
        return eventTypeRepository.findById(id).orElse(null);
    }
}
