package com.example.donateapp.serviceview.impl;

import com.example.donateapp.dto.donation.DonationReadDto;
import com.example.donateapp.dto.donation.DonationWriteDto;
import com.example.donateapp.entity.Donation;
import com.example.donateapp.mapper.DonationMapper;
import com.example.donateapp.service.CurrencyService;
import com.example.donateapp.service.DonationMethodService;
import com.example.donateapp.service.DonationService;
import com.example.donateapp.service.DonorService;
import com.example.donateapp.serviceview.DonationServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DonationServiceViewImpl implements DonationServiceView {

    @Autowired
    DonationService donationService;

    @Autowired
    CurrencyService currencyService;

    @Autowired
    DonationMethodService donationMethodService;

    @Autowired
    DonorService donorService;



    @Override
    public DonationReadDto save(DonationWriteDto donationWriteDto) {
        Donation donation = DonationMapper.toDonation(donationWriteDto);
//      set donationMethod, currency, donor from donationMethodId, currencyId, donorId
//      use donationService to find donationMethod, currency, donor by id
//      set donationMethod, currency, donor to donation
        donation.setDonationMethod(donationMethodService.findById(donationWriteDto.getDonationMethodId()));
        donation.setCurrency(currencyService.findById(donationWriteDto.getCurrencyId()));
        donation.setDonor(donorService.findById(donationWriteDto.getDonorId()));
        donationService.save(donation);
        return DonationMapper.toDonationReadDto(donation);
    }

    @Override
    public DonationReadDto findById(Long donationId) {
        return DonationMapper.toDonationReadDto(donationService.findById(donationId));
    }

    @Override
    public Iterable<DonationReadDto> findAll() {
        return donationService.findAll()
                .stream().map(DonationMapper::toDonationReadDto).toList();
    }

    @Override
    public DonationReadDto update(DonationWriteDto donationWriteDto, Long donationId) {
        Donation donation = DonationMapper.toDonation(donationWriteDto);
        donation.setDonationId(donationId);
//      set donationMethod, currency, donor from donationMethodId, currencyId, donorId
//      use donationService to find donationMethod, currency, donor by id
//      set donationMethod, currency, donor to donation
        donation.setDonationMethod(donationMethodService.findById(donationWriteDto.getDonationMethodId()));
        donation.setCurrency(currencyService.findById(donationWriteDto.getCurrencyId()));
        donation.setDonor(donorService.findById(donationWriteDto.getDonorId()));
        donationService.update(donation);
        return DonationMapper.toDonationReadDto(donation);
    }

    @Override
    public void deleteById(Long donationId) {
        donationService.deleteById(donationId);
    }

    @Override
    public void deleteAll() {
        donationService.deleteAll();
    }

    @Override
    public List<Object[]> getMaxDonationPerCurrency() {
        return donationService.getMaxDonationPerCurrency();
    }

    @Override
    public List<Object[]> getSumDonationPerCurrency() {
        return donationService.getSumDonationPerCurrency();
    }

    @Override
    public List<Object[]> getAvgDonationPerMethod() {
        return donationService.getAvgDonationPerMethod();
    }

    @Override
    public List<Object[]> getDonationsByTypeMethodCurrency() {
        return donationService.getDonationsByTypeMethodCurrency();
    }
}
