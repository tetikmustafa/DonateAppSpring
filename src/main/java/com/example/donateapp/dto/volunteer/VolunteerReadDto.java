package com.example.donateapp.dto.volunteer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VolunteerReadDto extends VolunteerWriteDto {
    private Long volunteerId;

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }
}
