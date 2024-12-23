package com.example.donateapp.service.impl;

import com.example.donateapp.entity.Donation;
import com.example.donateapp.repository.DonationRepository;
import com.example.donateapp.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    DonationRepository donationRepository;

    @Override
    public void save(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public Donation findById(Long donationId) {
        return donationRepository.findById(donationId).orElse(null);
    }

    @Override
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    @Override
    public void update(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public void deleteById(Long donationId) {
        donationRepository.deleteById(donationId);
    }

    @Override
    public void deleteAll() {
        donationRepository.deleteAll();
    }

    @Override
    public List<Object[]> getMaxDonationPerCurrency() {
        return donationRepository.getMaxDonationPerCurrency();
    }

    @Override
    public List<Object[]> getSumDonationPerCurrency() {
        return donationRepository.getSumDonationPerCurrency();
    }

    @Override
    public List<Object[]> getAvgDonationPerMethod() {
        return donationRepository.getAvgDonationPerMethod();
    }

    @Override
    public List<Object[]> getDonationsByTypeMethodCurrency() {
        return donationRepository.getDonationsByTypeMethodCurrency();
    }
}
