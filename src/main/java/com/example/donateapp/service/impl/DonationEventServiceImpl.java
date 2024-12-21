package com.example.donateapp.service.impl;

import com.example.donateapp.entity.Donation;
import com.example.donateapp.entity.DonationEvent;
import com.example.donateapp.entity.Event;
import com.example.donateapp.repository.DonationEventRepository;
import com.example.donateapp.repository.DonationRepository;
import com.example.donateapp.repository.EventRepository;
import com.example.donateapp.service.DonationEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DonationEventServiceImpl implements DonationEventService {

    @Autowired
    private DonationEventRepository donationEventRepository;

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private EventRepository eventRepository;

    public void assignDonationToEvent(Long donationId, Long eventId) {
        Donation donation = donationRepository.findById(donationId)
                .orElseThrow(() -> new RuntimeException("Donation not found"));
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        DonationEvent donationEvent = new DonationEvent();
        donationEvent.setDonation(donation);
        donationEvent.setEvent(event);
        donationEventRepository.save(donationEvent);
    }
}
