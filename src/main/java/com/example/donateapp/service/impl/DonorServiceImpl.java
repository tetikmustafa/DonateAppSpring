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
    public void save(Donor donor) {
        donorRepository.save(donor);
    }

    @Override
    public Donor findById(Long donorId) {
        return donorRepository.findById(donorId).orElse(null);
    }

    @Override
    public List<Donor> findAll() {
        return donorRepository.findAll();}

    @Override
    public void update(Donor donor) {
        donorRepository.save(donor);
    }

    @Override
    public void deleteById(Long donorId) {
        donorRepository.deleteById(donorId);
    }

    @Override
    public void deleteAll() {
        donorRepository.deleteAll();
    }

    @Override
    public List<Object[]> getDonorDetailsWithDonations() {
        return donorRepository.getDonorDetailsWithDonations();
    }

    @Override
    public List<Object[]> getDonorsWithDonationMethods() {
        return donorRepository.getDonorsWithDonationMethods();
    }

    @Override
    public List<Object[]> getDonorTotalDonations() {
        return donorRepository.getDonorTotalDonations();
    }

    @Override
    public List<Object[]> getDonorsWithDonationsAbove(Double amount) {
        return donorRepository.getDonorsWithDonationsAbove(amount);
    }
}
