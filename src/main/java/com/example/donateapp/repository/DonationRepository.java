package com.example.donateapp.repository;

import com.example.donateapp.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
/*
    @Query("""
    INSERT INTO Donations (donorID, donationDate, amount, description, donationMethodID, currencyID) 
    VALUES (:#{#donation.donorID}, :#{#donation.donationDate}, :#{#donation.amount}, :#{#donation.description}, :#{#donation.donationMethodID}, :#{#donation.currencyID})
""")
    void save(@Param("donation") Donation donation);

    @Query("""
    SELECT * FROM Donations WHERE donationID = :donationId
""")
    Donation findById(@Param("donationId") Long donationId);

    @Query("""
    SELECT * FROM Donations
""")
    List<Donation> findAll();

    @Query("""
    UPDATE Donations 
    SET donorID = :#{#donation.donorID}, donationDate = :#{#donation.donationDate}, amount = :#{#donation.amount}, description = :#{#donation.description}, donationMethodID = :#{#donation.donationMethodID}, currencyID = :#{#donation.currencyID} 
    WHERE donationID = :#{#donation.donationID}
""")
    void update(@Param("donation") Donation donation);

    @Query("""
    DELETE FROM Donations WHERE donationID = :donationId
""")
    void deleteById(@Param("donationId") Long donationId);

    @Query("""
    DELETE FROM Donations
""")
    void deleteAll();

*/

    @Query("""
    SELECT c.currencyName, MAX(don.amount) as maxAmount 
    FROM Donation don 
    JOIN Currency c ON don.currency.currencyId = c.currencyId 
    GROUP BY c.currencyName
""")
    List<Object[]> getMaxDonationPerCurrency();

    @Query("""
    SELECT c.currencyName, SUM(don.amount) as maxAmount 
    FROM Donation don 
    JOIN Currency c ON don.currency.currencyId = c.currencyId 
    GROUP BY c.currencyName
""")
    List<Object[]> getSumDonationPerCurrency();

    @Query("""
    SELECT dm.donationMethod, AVG(don.amount) as avgAmount 
    FROM Donation don 
    JOIN DonationMethod dm ON don.donationMethod.donationMethodId = dm.donationMethodId 
    GROUP BY dm.donationMethod
""")
    List<Object[]> getAvgDonationPerMethod();

    @Query("""
    SELECT dt.donationType, dm.donationMethod, c.currencyName, don.amount
        FROM Donation don
    	JOIN Donor d ON d.donorId = don.donor.donorId
        JOIN DonationType dt ON d.donationType.donationTypeId = dt.donationTypeId
        JOIN DonationMethod dm ON don.donationMethod.donationMethodId = dm.donationMethodId
        JOIN Currency c ON don.currency.currencyId = c.currencyId
        ORDER BY c.currencyName, don.amount DESC
""")
    List<Object[]> getDonationsByTypeMethodCurrency();
}
