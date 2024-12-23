package com.example.donateapp.serviceview;

import com.example.donateapp.dto.donor.DonorReadDto;
import com.example.donateapp.dto.donor.DonorWriteDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonorServiceView {

    DonorReadDto save(DonorWriteDto donorWriteDto);

    DonorReadDto findById(Long donorId);

    Iterable<DonorReadDto> findAll();

    DonorReadDto update(DonorWriteDto donorWriteDto, Long donorId);

    void deleteById(Long donorId);

    void deleteAll();

    List<Object[]> getDonorDetailsWithDonations();

    List<Object[]> getDonorsWithDonationMethods();

    List<Object[]> getDonorTotalDonations();

    List<Object[]> getDonorsWithDonationsAbove(@Param("amount") Double amount);

}
