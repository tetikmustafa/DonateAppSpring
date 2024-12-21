package com.example.donateapp.service;

import com.example.donateapp.entity.Donor;

import java.util.List;

public interface DonorService {
    void save(Donor donation);

    Donor findById(Long donationId);

    List<Donor> findAll();

    void update(Donor donation);

    void deleteById(Long donationId);

    void deleteAll();
}
