package com.example.donateapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Volunteer_Event")
public class VolunteerEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VolunteerEventID")
    private Long volunteerEventId;

    @ManyToOne
    @JoinColumn(name = "VolunteerID", nullable = false)
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "EventID", nullable = false)
    private Event event;

    public Long getVolunteerEventId() {
        return volunteerEventId;
    }

    public void setVolunteerEventId(Long volunteerEventId) {
        this.volunteerEventId = volunteerEventId;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
