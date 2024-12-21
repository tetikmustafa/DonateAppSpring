package com.example.donateapp.mapper;

import com.example.donateapp.dto.donation.DonationReadDto;
import com.example.donateapp.dto.donation.DonationWriteDto;
import com.example.donateapp.entity.Donation;

public class DonationMapper {
    public static DonationReadDto toDonationReadDto(Donation donation) {
        DonationReadDto donationReadDto = new DonationReadDto();
        donationReadDto.setDonationId(donation.getDonationId());
        donationReadDto.setDonationDate(donation.getDonationDate());
        donationReadDto.setAmount(donation.getAmount());
        donationReadDto.setDescription(donation.getDescription());
        donationReadDto.setDonationMethodId(donation.getDonationMethod().getDonationMethodId());
        donationReadDto.setCurrencyId(donation.getCurrency().getCurrencyId());
        donationReadDto.setDonorId(donation.getDonor().getDonorId());
        return donationReadDto;
    }


    public static Donation toDonation(DonationWriteDto donationWriteDto) {
        Donation donation = new Donation();
        donation.setDonationDate(donationWriteDto.getDonationDate());
        donation.setAmount(donationWriteDto.getAmount());
        donation.setDescription(donationWriteDto.getDescription());
        return donation;
    }
}
