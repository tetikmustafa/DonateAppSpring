package com.example.donateapp.service;

import com.example.donateapp.entity.Volunteer;

import java.util.List;

public interface VolunteerService {
    void save(Volunteer volunteer);

    Volunteer findById(Long volunteerId);

    List<Volunteer> findAll();

    void update(Volunteer volunteer);

    void deleteById(Long volunteerId);

    void deleteAll();
}
