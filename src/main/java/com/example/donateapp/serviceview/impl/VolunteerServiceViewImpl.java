package com.example.donateapp.serviceview.impl;

import com.example.donateapp.dto.volunteer.VolunteerReadDto;
import com.example.donateapp.dto.volunteer.VolunteerWriteDto;
import com.example.donateapp.entity.Volunteer;
import com.example.donateapp.mapper.VolunteerMapper;
import com.example.donateapp.service.TaskTypeService;
import com.example.donateapp.service.VolunteerService;
import com.example.donateapp.serviceview.VolunteerServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerServiceViewImpl implements VolunteerServiceView {

    @Autowired
    VolunteerService volunteerService;

    @Autowired
    TaskTypeService taskTypeService;

    @Override
    public VolunteerReadDto save(VolunteerWriteDto volunteerWriteDto) {
        Volunteer volunteer = VolunteerMapper.toVolunteer(volunteerWriteDto);
//       set TaskType from taskTypeId
//       use volunteerService to find TaskType by id
//       set TaskType to volunteer
        volunteer.setTaskType(taskTypeService.findById(volunteerWriteDto.getTaskTypeId()));
        volunteerService.save(volunteer);
        return VolunteerMapper.toVolunteerReadDto(volunteer);
    }

    @Override
    public VolunteerReadDto findById(Long volunteerId) {
        return VolunteerMapper.toVolunteerReadDto(volunteerService.findById(volunteerId));
    }

    @Override
    public Iterable<VolunteerReadDto> findAll() {
        return volunteerService.findAll()
                .stream().map(VolunteerMapper::toVolunteerReadDto).toList();
    }

    @Override
    public VolunteerReadDto update(VolunteerWriteDto volunteerWriteDto, Long volunteerId) {
        Volunteer volunteer = VolunteerMapper.toVolunteer(volunteerWriteDto);
        volunteer.setVolunteerId(volunteerId);
//       set TaskType from taskTypeId
//       use volunteerService to find TaskType by id
//       set TaskType to volunteer
        volunteer.setTaskType(taskTypeService.findById(volunteerWriteDto.getTaskTypeId()));
        volunteerService.update(volunteer);
        return VolunteerMapper.toVolunteerReadDto(volunteer);
    }

    @Override
    public void deleteById(Long volunteerId) {
        volunteerService.deleteById(volunteerId);
    }

    @Override
    public void deleteAll() {
        volunteerService.deleteAll();
    }

    @Override
    public List<Object[]> getVolunteersWithTasks() {
        return volunteerService.getVolunteersWithTasks();
    }
}
