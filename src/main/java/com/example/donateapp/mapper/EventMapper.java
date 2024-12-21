package com.example.donateapp.mapper;

import com.example.donateapp.dto.event.EventReadDto;
import com.example.donateapp.dto.event.EventWriteDto;
import com.example.donateapp.entity.Event;

public class EventMapper {
    public static EventReadDto toEventReadDto(Event event) {
        EventReadDto eventReadDto = new EventReadDto();
        eventReadDto.setEventId(event.getEventId());
        eventReadDto.setEventName(event.getEventName());
        eventReadDto.setEventDate(event.getEventDate());
        eventReadDto.setLocation(event.getLocation());
        eventReadDto.setDescription(event.getDescription());
        eventReadDto.setEventTypeId(event.getEventType().getEventTypeId());
        return eventReadDto;
    }

    public static Event toEvent(EventWriteDto eventWriteDto) {
        Event event = new Event();
        event.setEventName(eventWriteDto.getEventName());
        event.setEventDate(eventWriteDto.getEventDate());
        event.setLocation(eventWriteDto.getLocation());
        event.setDescription(eventWriteDto.getDescription());
        return event;
    }
}
