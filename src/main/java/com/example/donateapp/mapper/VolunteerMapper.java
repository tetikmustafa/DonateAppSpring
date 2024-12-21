package com.example.donateapp.mapper;

import com.example.donateapp.dto.volunteer.VolunteerReadDto;
import com.example.donateapp.dto.volunteer.VolunteerWriteDto;
import com.example.donateapp.entity.Volunteer;

public class VolunteerMapper {
    public static VolunteerReadDto toVolunteerReadDto(Volunteer volunteer) {
        VolunteerReadDto volunteerReadDto = new VolunteerReadDto();
        volunteerReadDto.setVolunteerId(volunteer.getVolunteerId());
        volunteerReadDto.setFirstName(volunteer.getFirstName());
        volunteerReadDto.setLastName(volunteer.getLastName());
        volunteerReadDto.setPhone(volunteer.getPhone());
        volunteerReadDto.setTaskTypeId(volunteer.getTaskType().getTaskTypeId());
        return volunteerReadDto;
    }

    public static Volunteer toVolunteer(VolunteerWriteDto volunteerWriteDto) {
        Volunteer volunteer = new Volunteer();
        volunteer.setFirstName(volunteerWriteDto.getFirstName());
        volunteer.setLastName(volunteerWriteDto.getLastName());
        volunteer.setPhone(volunteerWriteDto.getPhone());
        return volunteer;
    }
}
