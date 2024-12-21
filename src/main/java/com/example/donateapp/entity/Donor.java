package com.example.donateapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "donors")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DonorID")
    private Long donorId;

    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Email")
    private String email;
    @Column(name = "Address")
    private String address;
    @Column(name = "Phone")
    private String phone;

    @Column(name = "MembershipStatus")
    private boolean membershipStatus;

    @ManyToOne
    @JoinColumn(name = "DonationTypeID", nullable = false)
    private DonationType donationType;


//    // İlişkilendirme (Donation ile OneToMany olabilir)
//     @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL)
//     private List<Donation> donations;


    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(boolean membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public DonationType getDonationType() {
        return donationType;
    }

    public void setDonationType(DonationType donationType) {
        this.donationType = donationType;
    }
}
