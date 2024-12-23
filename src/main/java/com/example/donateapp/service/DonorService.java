package com.example.donateapp.service;

import com.example.donateapp.entity.Donor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonorService {
    void save(Donor donor);

    Donor findById(Long donorId);

    List<Donor> findAll();

    void update(Donor donor);

    void deleteById(Long donorId);

    void deleteAll();

    List<Object[]> getDonorDetailsWithDonations();

    List<Object[]> getDonorsWithDonationMethods();

    List<Object[]> getDonorTotalDonations();

    List<Object[]> getDonorsWithDonationsAbove(@Param("amount") Double amount);


}
