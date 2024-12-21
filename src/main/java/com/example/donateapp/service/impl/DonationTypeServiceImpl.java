package com.example.donateapp.service.impl;

import com.example.donateapp.entity.DonationType;
import com.example.donateapp.repository.DonationTypeRepository;
import com.example.donateapp.service.DonationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationTypeServiceImpl implements DonationTypeService {

    @Autowired
    DonationTypeRepository donationTypeRepository;

    @Override
    public DonationType findById(Long id) {
        return donationTypeRepository.findById(id).orElse(null);
    }
}
