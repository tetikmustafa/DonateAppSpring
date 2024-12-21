package com.example.donateapp.serviceview;

import com.example.donateapp.dto.donor.DonorReadDto;
import com.example.donateapp.dto.donor.DonorWriteDto;

public interface DonorServiceView {

    DonorReadDto save(DonorWriteDto donorWriteDto);

    DonorReadDto findById(Long donorId);

    Iterable<DonorReadDto> findAll();

    DonorReadDto update(DonorWriteDto donorWriteDto, Long donorId);

    void deleteById(Long donorId);

    void deleteAll();
}
