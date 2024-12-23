package com.example.donateapp.service.impl;

import com.example.donateapp.entity.Volunteer;
import com.example.donateapp.repository.VolunteerRepository;
import com.example.donateapp.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    VolunteerRepository volunteerRepository;

    @Override
    public void save(Volunteer volunteer) {
        volunteerRepository.save(volunteer);
    }

    @Override
    public Volunteer findById(Long volunteerId) {
        return volunteerRepository.findById(volunteerId).orElse(null);
    }

    @Override
    public List<Volunteer> findAll() {
        return volunteerRepository.findAll();
    }

    @Override
    public void update(Volunteer volunteer) {
        volunteerRepository.save(volunteer);
    }

    @Override
    public void deleteById(Long volunteerId) {
        volunteerRepository.deleteById(volunteerId);
    }

    @Override
    public void deleteAll() {
        volunteerRepository.deleteAll();
    }

    @Override
    public List<Object[]> getVolunteersWithTasks() {
        return volunteerRepository.getVolunteersWithTasks();
    }
}
