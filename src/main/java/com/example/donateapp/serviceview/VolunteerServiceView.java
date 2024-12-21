package com.example.donateapp.serviceview;

import com.example.donateapp.dto.volunteer.VolunteerReadDto;
import com.example.donateapp.dto.volunteer.VolunteerWriteDto;

public interface VolunteerServiceView {

    VolunteerReadDto save(VolunteerWriteDto volunteerWriteDto);

    VolunteerReadDto findById(Long volunteerId);

    Iterable<VolunteerReadDto> findAll();

    VolunteerReadDto update(VolunteerWriteDto volunteerWriteDto, Long volunteerId);

    void deleteById(Long volunteerId);

    void deleteAll();

}
