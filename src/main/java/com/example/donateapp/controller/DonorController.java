package com.example.donateapp.controller;

import com.example.donateapp.dto.donor.DonorReadDto;
import com.example.donateapp.dto.donor.DonorWriteDto;
import com.example.donateapp.serviceview.DonorServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("api/donors")
public class DonorController {

    @Autowired
    DonorServiceView donorServiceView;

    @PostMapping()
    public ResponseEntity<DonorReadDto> save(@RequestBody DonorWriteDto donorWriteDto) {
        return new ResponseEntity<>(donorServiceView.save(donorWriteDto) , HttpStatus.CREATED);
    }

    @GetMapping("/{donorId}")
    public ResponseEntity<DonorReadDto> findById(@PathVariable Long donorId) {
        return new ResponseEntity<>(donorServiceView.findById(donorId) , HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<DonorReadDto>> findAll() {
        return new ResponseEntity<>(donorServiceView.findAll() , HttpStatus.OK);
    }

    @PutMapping("/{donorId}")
    public ResponseEntity<DonorReadDto> update(@RequestBody DonorWriteDto donorWriteDto, @PathVariable Long donorId) {
        return new ResponseEntity<>(donorServiceView.update(donorWriteDto, donorId) , HttpStatus.OK);
    }

    @DeleteMapping("/{donorId}")
    public ResponseEntity<String> deleteById(@PathVariable Long donorId) {
        donorServiceView.deleteById(donorId);
        return new ResponseEntity<>("Donor with id " + donorId + " has been deleted", HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAll() {
        donorServiceView.deleteAll();
        return new ResponseEntity<>("All donors have been deleted", HttpStatus.OK);
    }

    @GetMapping("/donorDetailsWithDonations")
    public ResponseEntity<Object> getDonorDetailsWithDonations() {
        return new ResponseEntity<>(donorServiceView.getDonorDetailsWithDonations() , HttpStatus.OK);
    }

    @GetMapping("/donorsWithDonationMethods")
    public ResponseEntity<Object> getDonorsWithDonationMethods() {
        return new ResponseEntity<>(donorServiceView.getDonorsWithDonationMethods() , HttpStatus.OK);
    }

    @GetMapping("/donorTotalDonations")
    public ResponseEntity<Object> getDonorTotalDonations() {
        return new ResponseEntity<>(donorServiceView.getDonorTotalDonations() , HttpStatus.OK);
    }

    @GetMapping("/donorsWithDonationsAbove/{amount}")
    public ResponseEntity<Object> getDonorsWithDonationsAbove(@PathVariable Double amount) {
        return new ResponseEntity<>(donorServiceView.getDonorsWithDonationsAbove(amount) , HttpStatus.OK);
    }
}
