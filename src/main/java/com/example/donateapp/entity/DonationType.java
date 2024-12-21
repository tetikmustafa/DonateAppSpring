package com.example.donateapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "donationTypes")
public class DonationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DonationTypeID")
    private Long donationTypeId;

    @Column(name = "DonationType")
    private String donationType;

    public Long getDonationTypeId() {
        return donationTypeId;
    }

    public void setDonationTypeId(Long donationTypeId) {
        this.donationTypeId = donationTypeId;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }
}
