package com.example.donateapp.serviceview;

import com.example.donateapp.dto.event.EventReadDto;
import com.example.donateapp.dto.event.EventWriteDto;

public interface EventServiceView {

    EventReadDto save(EventWriteDto eventWriteDto);

    EventReadDto findById(Long eventId);

    Iterable<EventReadDto> findAll();

    EventReadDto update(EventWriteDto eventWriteDto, Long eventId);

    void deleteById(Long eventId);

    void deleteAll();
}
