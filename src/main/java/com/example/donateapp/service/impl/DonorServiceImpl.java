package com.example.donateapp.service.impl;

import com.example.donateapp.entity.Donor;
import com.example.donateapp.repository.DonorRepository;
import com.example.donateapp.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    DonorRepository donorRepository;

    @Override
    public void save(Donor donation) {
        donorRepository.save(donation);
    }

    @Override
    public Donor findById(Long donationId) {
        return donorRepository.findById(donationId).orElse(null);
    }

    @Override
    public List<Donor> findAll() {
        return donorRepository.findAll();}

    @Override
    public void update(Donor donation) {
        donorRepository.save(donation);
    }

    @Override
    public void deleteById(Long donationId) {
        donorRepository.deleteById(donationId);
    }

    @Override
    public void deleteAll() {
        donorRepository.deleteAll();
    }
}
