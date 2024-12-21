package com.example.donateapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "donations")
@Builder
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DonationID")
    private Long donationId;

    @Column(name = "DonationDate")
    private Date donationDate;

    @Column(name = "Amount")
    private Double amount;

    @Column(name = "Description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "DonationMethodID", nullable = false)
    private DonationMethod donationMethod;

    @ManyToOne
    @JoinColumn(name = "CurrencyID", nullable = false)
    private Currency currency;

    // İlişkilendirme (Donor ile ManyToOne olabilir)
    @ManyToOne
    @JoinColumn(name = "DonorID", nullable = false)
    private Donor donor;

    @OneToMany(mappedBy = "donation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DonationEvent> donationEvents = new ArrayList<>();


    public Long getDonationId() {
        return donationId;
    }

    public void setDonationId(Long donationId) {
        this.donationId = donationId;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DonationMethod getDonationMethod() {
        return donationMethod;
    }

    public void setDonationMethod(DonationMethod donationMethod) {
        this.donationMethod = donationMethod;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }
}
