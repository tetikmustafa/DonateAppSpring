package com.example.donateapp.mapper;

import com.example.donateapp.dto.donor.DonorReadDto;
import com.example.donateapp.dto.donor.DonorWriteDto;
import com.example.donateapp.entity.Donor;

public class DonorMapper {
    public static DonorReadDto toDonorReadDto(Donor donor) {
        DonorReadDto donorReadDto = new DonorReadDto();
        donorReadDto.setDonorId(donor.getDonorId());
        donorReadDto.setFirstName(donor.getFirstName());
        donorReadDto.setLastName(donor.getLastName());
        donorReadDto.setEmail(donor.getEmail());
        donorReadDto.setAddress(donor.getAddress());
        donorReadDto.setPhone(donor.getPhone());
        donorReadDto.setMembershipStatus(donor.isMembershipStatus());
        donorReadDto.setDonationTypeId(donor.getDonationType().getDonationTypeId());
        return donorReadDto;
    }

    public static Donor toDonor(DonorWriteDto donorWriteDto) {
        Donor donor = new Donor();
        donor.setFirstName(donorWriteDto.getFirstName());
        donor.setLastName(donorWriteDto.getLastName());
        donor.setEmail(donorWriteDto.getEmail());
        donor.setPhone(donorWriteDto.getPhone());
        donor.setAddress(donorWriteDto.getAddress());
        donor.setMembershipStatus(donorWriteDto.isMembershipStatus());
        return donor;
    }
}
