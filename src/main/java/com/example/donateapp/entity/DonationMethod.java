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
@Table(name = "donationMethods")
public class DonationMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DonationMethodID")
    private Long donationMethodId;

    @Column(name = "DonationMethod")
    private String donationMethod;

    public Long getDonationMethodId() {
        return donationMethodId;
    }

    public void setDonationMethodId(Long donationMethodId) {
        this.donationMethodId = donationMethodId;
    }

    public String getDonationMethod() {
        return donationMethod;
    }

    public void setDonationMethod(String donationMethod) {
        this.donationMethod = donationMethod;
    }
}
