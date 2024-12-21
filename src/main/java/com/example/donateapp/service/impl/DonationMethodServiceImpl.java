package com.example.donateapp.service.impl;

import com.example.donateapp.entity.DonationMethod;
import com.example.donateapp.repository.DonationMethodRepository;
import com.example.donateapp.service.DonationMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationMethodServiceImpl implements DonationMethodService {

    @Autowired
    DonationMethodRepository donationMethodRepository;

    @Override
    public DonationMethod findById(Long id) {
        return donationMethodRepository.findById(id).orElse(null);
    }
}
