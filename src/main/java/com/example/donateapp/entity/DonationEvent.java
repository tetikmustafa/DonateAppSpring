package com.example.donateapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Donation_Event")
public class DonationEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DonationEventID")
    private Long donationEventId;

    @ManyToOne
    @JoinColumn(name = "DonationID", nullable = false)
    private Donation donation;

    @ManyToOne
    @JoinColumn(name = "EventID", nullable = false)
    private Event event;

    public Long getDonationEventId() {
        return donationEventId;
    }

    public void setDonationEventId(Long donationEventId) {
        this.donationEventId = donationEventId;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
