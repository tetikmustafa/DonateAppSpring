package com.example.donateapp.serviceview;

import com.example.donateapp.dto.donation.DonationReadDto;
import com.example.donateapp.dto.donation.DonationWriteDto;

public interface DonationServiceView {

    DonationReadDto save(DonationWriteDto donationWriteDto);

    DonationReadDto findById(Long donationId);

    Iterable<DonationReadDto> findAll();

    DonationReadDto update(DonationWriteDto donationWriteDto, Long donationId);

    void deleteById(Long donationId);

    void deleteAll();
}
