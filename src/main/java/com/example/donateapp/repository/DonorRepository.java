package com.example.donateapp.repository;

import com.example.donateapp.entity.Donor;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
/*
    @Modifying
    @Query("""
            INSERT INTO Donors (firstName, lastName, phone, email, address, membershipStatus, donationTypeID) 
            VALUES (:firstName, :lastName, :phone, :email, :address, :membershipStatus, :donationTypeID)
 """)
    void save(@Param("firstName") String firstName,
              @Param("lastName") String lastName,
              @Param("phone") String phone,
              @Param("email") String email,
              @Param("address") String address,
              @Param("membershipStatus") String membershipStatus,
              @Param("donationTypeID") Long donationTypeID);

    @Query("SELECT d FROM Donors d WHERE d.donorId = :donorId")
    Donor findById(@Param("donorId") Long donorId);

    @Query("SELECT d FROM Donor d")
    List<Donor> findAll();

    @Modifying
    @Query("UPDATE Donors d SET d.firstName = :firstName, d.lastName = :lastName, d.phone = :phone, d.email = :email, d.address = :address, d.membershipStatus = :membershipStatus, d.donationTypeID = :donationTypeID WHERE d.donorId = :donorId")
    void update(@Param("donorId") Long donorId,
                @Param("firstName") String firstName,
                @Param("lastName") String lastName,
                @Param("phone") String phone,
                @Param("email") String email,
                @Param("address") String address,
                @Param("membershipStatus") String membershipStatus,
                @Param("donationTypeID") Long donationTypeID);

    @Modifying
    @Query("DELETE FROM Donors d WHERE d.donorId = :donorId")
    void deleteById(@Param("donorId") Long donorId);

    @Modifying
    @Query("DELETE FROM Donors")
    void deleteAll();

 */
    @Query("""
            SELECT d.firstName, d.lastName, d.email, dm.donationMethod, don.donationDate, don.amount, c.currencyName
                FROM Donor d
                JOIN Donation don ON d.donorId = don.donor.donorId
                JOIN DonationMethod dm ON don.donationMethod.donationMethodId = dm.donationMethodId
                JOIN Currency c ON don.currency.currencyId = c.currencyId
            	GROUP BY d.firstName, d.lastName, d.email, dm.donationMethod, don.donationDate, don.amount, c.currencyName\s
            	HAVING don.amount > 200
            	ORDER BY d.firstName ASC
            """)
    List<Object[]> getDonorDetailsWithDonations();

    @Query("""
    SELECT d.firstName, d.lastName, dm.donationMethod 
    FROM Donor d 
    JOIN Donation don ON d.donorId = don.donor.donorId 
    JOIN DonationMethod dm ON don.donationMethod.donationMethodId = dm.donationMethodId
""")
    List<Object[]> getDonorsWithDonationMethods();

    @Query("""
    SELECT d.firstName, d.lastName, d.phone, SUM(don.amount) as totalDonation 
    FROM Donor d 
    JOIN Donation don ON d.donorId = don.donor.donorId 
    GROUP BY d.firstName, d.lastName, d.phone
""")
    List<Object[]> getDonorTotalDonations();

    @Query("""
    SELECT d.firstName, d.lastName, d.phone, don.amount 
    FROM Donor d 
    JOIN Donation don ON d.donorId = don.donor.donorId 
    WHERE don.amount > :amount
""")
    List<Object[]> getDonorsWithDonationsAbove(@Param("amount") Double amount);
}
