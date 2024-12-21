package com.example.donateapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EventID")
    private Long eventId;



    @Column(name = "EventName")
    private String eventName;

    @Column(name = "EventDate")
    private Date eventDate;
    @Column(name = "Location")
    private String location;
    @Column(name = "Description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "EventTypeID", nullable = false)
    private EventType eventType;

//    // İlişkilendirme (Volunteer ile ManyToMany olabilir)
//    @ManyToMany(mappedBy = "events")
//    private List<Volunteer> volunteers;
//
//    // İlişkilendirme (Donation ile OneToMany olabilir)
//    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
//    private List<Donation> donations;


    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
