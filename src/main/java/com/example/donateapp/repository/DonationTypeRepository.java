package com.example.donateapp.repository;

import com.example.donateapp.entity.DonationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationTypeRepository extends JpaRepository<DonationType, Long> {
}
