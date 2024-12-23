package com.example.donateapp.service;

import com.example.donateapp.entity.Donation;

import java.util.List;

public interface DonationService {
    void save(Donation donation);

    Donation findById(Long donationId);

    List<Donation> findAll();

    void update(Donation donation);

    void deleteById(Long donationId);

    void deleteAll();

    List<Object[]> getMaxDonationPerCurrency();

    List<Object[]> getSumDonationPerCurrency();

    List<Object[]> getAvgDonationPerMethod();

    List<Object[]> getDonationsByTypeMethodCurrency();

}
