package com.example.donateapp.serviceview.impl;

import com.example.donateapp.dto.event.EventReadDto;
import com.example.donateapp.dto.event.EventWriteDto;
import com.example.donateapp.entity.Event;
import com.example.donateapp.mapper.EventMapper;
import com.example.donateapp.service.EventService;
import com.example.donateapp.service.EventTypeService;
import com.example.donateapp.serviceview.EventServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceViewImpl implements EventServiceView {

    @Autowired
    EventService eventService;

    @Autowired
    EventTypeService eventTypeService;

    @Override
    public EventReadDto save(EventWriteDto eventWriteDto) {
        Event event = EventMapper.toEvent(eventWriteDto);
//      set EventType from eventTypeId
//      use eventService to find EventType by id
//      set EventType to event
        event.setEventType(eventTypeService.findById(eventWriteDto.getEventTypeId()));
        eventService.save(event);
        return EventMapper.toEventReadDto(event);
    }

    @Override
    public EventReadDto findById(Long eventId) {
        return EventMapper.toEventReadDto(eventService.findById(eventId));
    }

    @Override
    public Iterable<EventReadDto> findAll() {
        return eventService.findAll()
                .stream().map(EventMapper::toEventReadDto).toList();
    }

    @Override
    public EventReadDto update(EventWriteDto eventWriteDto, Long eventId) {
        Event event = EventMapper.toEvent(eventWriteDto);
        event.setEventId(eventId);
//      set EventType from eventTypeId
//      use eventService to find EventType by id
//      set EventType to event
        event.setEventType(eventTypeService.findById(eventWriteDto.getEventTypeId()));
        eventService.update(event);
        return EventMapper.toEventReadDto(event);
    }

    @Override
    public void deleteById(Long eventId) {
        eventService.deleteById(eventId);
    }

    @Override
    public void deleteAll() {
        eventService.deleteAll();
    }
}
