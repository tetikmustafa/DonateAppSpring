package com.example.donateapp.controller;

import com.example.donateapp.dto.donation.DonationReadDto;
import com.example.donateapp.dto.donation.DonationWriteDto;
import com.example.donateapp.serviceview.DonationServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("api/donations")
public class DonationController {

    @Autowired
    DonationServiceView donationServiceView;

    @PostMapping()
    public ResponseEntity<DonationReadDto> save(@RequestBody DonationWriteDto donationWriteDto) {
        return new ResponseEntity<>(donationServiceView.save(donationWriteDto) , HttpStatus.CREATED);
    }

    @GetMapping("/{donationId}")
    public ResponseEntity<DonationReadDto> findById(@PathVariable Long donationId) {
        return new ResponseEntity<>(donationServiceView.findById(donationId) , HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<DonationReadDto>> findAll() {
        return new ResponseEntity<>(donationServiceView.findAll() , HttpStatus.OK);
    }

    @PutMapping("/{donationId}")
    public ResponseEntity<DonationReadDto> update(@RequestBody DonationWriteDto donationWriteDto, @PathVariable Long donationId) {
        return new ResponseEntity<>(donationServiceView.update(donationWriteDto, donationId) , HttpStatus.OK);
    }

    @DeleteMapping("/{donationId}")
    public ResponseEntity<String> deleteById(@PathVariable Long donationId) {
        donationServiceView.deleteById(donationId);
        return new ResponseEntity<>("Donation with id " + donationId + " has been deleted", HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAll() {
        donationServiceView.deleteAll();
        return new ResponseEntity<>("All donations have been deleted", HttpStatus.OK);
    }
}
