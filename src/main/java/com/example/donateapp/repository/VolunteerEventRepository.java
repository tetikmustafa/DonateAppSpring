package com.example.donateapp.repository;

import com.example.donateapp.entity.VolunteerEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerEventRepository extends JpaRepository<VolunteerEvent, Long> {
}
