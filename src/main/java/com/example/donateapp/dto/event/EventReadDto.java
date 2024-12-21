package com.example.donateapp.dto.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventReadDto extends EventWriteDto{
    private Long eventId;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
