package com.example.donateapp.repository;

import com.example.donateapp.entity.DonationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationEventRepository extends JpaRepository<DonationEvent, Long> {
}
