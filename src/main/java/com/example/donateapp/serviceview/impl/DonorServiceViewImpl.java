package com.example.donateapp.serviceview.impl;

import com.example.donateapp.dto.donor.DonorReadDto;
import com.example.donateapp.dto.donor.DonorWriteDto;
import com.example.donateapp.entity.Donor;
import com.example.donateapp.mapper.DonorMapper;
import com.example.donateapp.service.DonationTypeService;
import com.example.donateapp.service.DonorService;
import com.example.donateapp.serviceview.DonorServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorServiceViewImpl implements DonorServiceView {

    @Autowired
    DonorService donorService;

    @Autowired
    DonationTypeService donationTypeService;

    @Override
    public DonorReadDto save(DonorWriteDto donorWriteDto) {
        Donor donor = DonorMapper.toDonor(donorWriteDto);
//      set donationType from donationTypeId
//      use donationService to find donationType by id
//      set donationType to donation
        donor.setDonationType(donationTypeService.findById(donorWriteDto.getDonationTypeId()));
        donorService.save(donor);
        return DonorMapper.toDonorReadDto(donor);
    }

    @Override
    public DonorReadDto findById(Long donorId) {
        return DonorMapper.toDonorReadDto(donorService.findById(donorId));
    }

    @Override
    public Iterable<DonorReadDto> findAll() {
        return donorService.findAll()
                .stream().map(DonorMapper::toDonorReadDto).toList();
    }

    @Override
    public DonorReadDto update(DonorWriteDto donorWriteDto, Long donorId) {
        Donor donor = DonorMapper.toDonor(donorWriteDto);
        donor.setDonorId(donorId);
//      set donationType from donationTypeId
//      use donationService to find donationType by id
//      set donationType to donation
        donor.setDonationType(donationTypeService.findById(donorWriteDto.getDonationTypeId()));
        donorService.update(donor);
        return DonorMapper.toDonorReadDto(donor);
    }

    @Override
    public void deleteById(Long donorId) {
        donorService.deleteById(donorId);
    }

    @Override
    public void deleteAll() {
        donorService.deleteAll();
    }
}
