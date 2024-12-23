package com.example.donateapp.controller;

import com.example.donateapp.dto.event.EventReadDto;
import com.example.donateapp.dto.event.EventWriteDto;
import com.example.donateapp.service.DonationEventService;
import com.example.donateapp.service.VolunteerEventService;
import com.example.donateapp.serviceview.EventServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("api/events")
public class EventController {

    @Autowired
    EventServiceView eventServiceView;

    @Autowired
    DonationEventService donationEventService;

    @Autowired
    VolunteerEventService volunteerEventService;

    @PostMapping()
    public ResponseEntity<EventReadDto> save(@RequestBody EventWriteDto eventWriteDto) {
        return new ResponseEntity<>(eventServiceView.save(eventWriteDto), HttpStatus.CREATED);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventReadDto> findById(@PathVariable Long eventId) {
        return new ResponseEntity<>(eventServiceView.findById(eventId), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<EventReadDto>> findAll() {
        return new ResponseEntity<>(eventServiceView.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<EventReadDto> update(@RequestBody EventWriteDto eventWriteDto, @PathVariable Long eventId) {
        return new ResponseEntity<>(eventServiceView.update(eventWriteDto, eventId), HttpStatus.OK);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<String> deleteById(@PathVariable Long eventId) {
        eventServiceView.deleteById(eventId);
        return new ResponseEntity<>("Event with id " + eventId + " has been deleted", HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAll() {
        eventServiceView.deleteAll();
        return new ResponseEntity<>("All events have been deleted", HttpStatus.OK);
    }

    @PostMapping("/{donationId}/event/{eventId}")
    public ResponseEntity<String> assignDonationToEvent(
            @PathVariable Long donationId,
            @PathVariable Long eventId) {

        donationEventService.assignDonationToEvent(donationId, eventId);
        return new ResponseEntity<>("Donation assigned to event successfully.", HttpStatus.OK);
    }

    @PostMapping("/{volunteerId}/event/{eventId}")
    public ResponseEntity<String> assignVolunteerToEvent(
            @PathVariable Long volunteerId,
            @PathVariable Long eventId) {

        volunteerEventService.assignVolunteerToEvent(volunteerId, eventId);
        return new ResponseEntity<>("Volunteer assigned to event successfully.", HttpStatus.OK);
    }

    @GetMapping("/totalDonationsPerEvent")
    public ResponseEntity<Iterable<Object[]>> getTotalDonationsPerEvent() {
        return new ResponseEntity<>(eventServiceView.getTotalDonationsPerEvent(), HttpStatus.OK);
    }

    @GetMapping("/eventsWithoutDonations")
    public ResponseEntity<Iterable<Object[]>> getEventsWithoutDonations() {
        return new ResponseEntity<>(eventServiceView.getEventsWithoutDonations(), HttpStatus.OK);
    }

    @GetMapping("/eventVolunteerDonationsByCurrency")
    public ResponseEntity<Iterable<Object[]>> getEventVolunteerDonationsByCurrency() {
        return new ResponseEntity<>(eventServiceView.getEventVolunteerDonationsByCurrency(), HttpStatus.OK);
    }
}
