package com.example.donateapp.dto.event;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class EventWriteDto {
    private String eventName;
    private Date eventDate;
    private String location;
    private String description;

    private Long eventTypeId; // service layer will set this field

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

    public Long getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Long eventTypeId) {
        this.eventTypeId = eventTypeId;
    }
}
