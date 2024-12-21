package com.example.donateapp.dto.donation;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
public class DonationWriteDto {

    private Date donationDate;
    private Double amount;
    private String description;

    private Long donationMethodId; // service layer will set this layer
    private Long currencyId; // service layer will set this layer
    private Long donorId; // service layer will set this layer

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

    public Long getDonationMethodId() {
        return donationMethodId;
    }

    public void setDonationMethodId(Long donationMethodId) {
        this.donationMethodId = donationMethodId;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }
}
