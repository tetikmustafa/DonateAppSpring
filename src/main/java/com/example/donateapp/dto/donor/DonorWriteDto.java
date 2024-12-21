package com.example.donateapp.dto.donor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonorWriteDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    private boolean membershipStatus;

    private Long donationTypeId; // service layer will set this field

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(boolean membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public Long getDonationTypeId() {
        return donationTypeId;
    }

    public void setDonationTypeId(Long donationTypeId) {
        this.donationTypeId = donationTypeId;
    }
}
