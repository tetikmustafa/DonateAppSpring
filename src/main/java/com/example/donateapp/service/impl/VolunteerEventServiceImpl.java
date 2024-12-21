package com.example.donateapp.service.impl;

import com.example.donateapp.entity.Volunteer;
import com.example.donateapp.entity.VolunteerEvent;
import com.example.donateapp.entity.Event;
import com.example.donateapp.repository.VolunteerEventRepository;
import com.example.donateapp.repository.VolunteerRepository;
import com.example.donateapp.repository.EventRepository;
import com.example.donateapp.service.VolunteerEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerEventServiceImpl implements VolunteerEventService {

    @Autowired
    private VolunteerEventRepository volunteerEventRepository;

    @Autowired
    private VolunteerRepository volunteerRepository;

    @Autowired
    private EventRepository eventRepository;

    public void assignVolunteerToEvent(Long volunteerId, Long eventId) {
        Volunteer volunteer = volunteerRepository.findById(volunteerId)
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        VolunteerEvent volunteerEvent = new VolunteerEvent();
        volunteerEvent.setVolunteer(volunteer);
        volunteerEvent.setEvent(event);
        volunteerEventRepository.save(volunteerEvent);
    }
}
