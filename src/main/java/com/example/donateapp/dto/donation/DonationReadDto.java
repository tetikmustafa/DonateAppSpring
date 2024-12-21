package com.example.donateapp.dto.donation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonationReadDto extends DonationWriteDto{
    private Long donationId;

    public Long getDonationId() {
        return donationId;
    }

    public void setDonationId(Long donationId) {
        this.donationId = donationId;
    }
}
