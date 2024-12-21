package com.example.donateapp.repository;

import com.example.donateapp.entity.DonationMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationMethodRepository extends JpaRepository<DonationMethod, Long> {
}
