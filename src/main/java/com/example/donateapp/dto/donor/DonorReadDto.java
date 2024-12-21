package com.example.donateapp.dto.donor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonorReadDto  extends DonorWriteDto{
    private Long donorId;

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }
}
