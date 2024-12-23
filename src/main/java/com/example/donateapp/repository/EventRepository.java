package com.example.donateapp.repository;

import com.example.donateapp.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
/*
    @Modifying
    @Query("INSERT INTO Events (eventName, eventDate, location, description, eventType) " +
            "VALUES (:eventName, :eventDate, :location, :description, :eventType)")
    void save(@Param("eventName") String eventName,
              @Param("eventDate") LocalDate eventDate,
              @Param("location") String location,
              @Param("description") String description,
              @Param("eventType") Long eventType);

    @Query("SELECT e FROM Events e WHERE e.eventId = :eventId")
    Event findById(@Param("eventId") Long eventId);

    @Query("SELECT e FROM Events e")
    List<Event> findAll();

    @Modifying
    @Query("UPDATE Events e SET e.eventName = :eventName, e.eventDate = :eventDate, " +
            "e.location = :location, e.description = :description, e.eventType = :eventType " +
            "WHERE e.eventId = :eventId")
    void update(@Param("eventId") Long eventId,
                @Param("eventName") String eventName,
                @Param("eventDate") LocalDate eventDate,
                @Param("location") String location,
                @Param("description") String description,
                @Param("eventType") Long eventType);

    @Modifying
    @Query("DELETE FROM Events e WHERE e.eventId = :eventId")
    void deleteById(@Param("eventId") Long eventId);

    @Modifying
    @Query("DELETE FROM Events")
    void deleteAll();

 */

    @Query("""
    SELECT e.eventName, SUM(don.amount) as totalDonations 
    FROM Event e 
    JOIN DonationEvent de ON e.eventId = de.event.eventId 
    JOIN Donation don ON de.donation.donationId = don.donationId 
    GROUP BY e.eventName
""")
    List<Object[]> getTotalDonationsPerEvent();

    @Query("""
    SELECT e.eventName, e.eventDate 
    FROM Event e 
    WHERE e.eventId NOT IN (SELECT DISTINCT de.event.eventId FROM DonationEvent de)
""")
    List<Object[]> getEventsWithoutDonations();

    @Query("""
    SELECT e.eventName, e.eventDate, et.eventType, v.firstName, v.phone, c.currencyName, AVG(don.amount) as avgAmount 
    FROM Event e 
    JOIN EventType et ON e.eventType.eventTypeId = et.eventTypeId 
    JOIN VolunteerEvent ve ON e.eventId = ve.event.eventId 
    JOIN Volunteer v ON ve.volunteer.volunteerId = v.volunteerId 
    JOIN DonationEvent de ON e.eventId = de.event.eventId 
    JOIN Donation don ON de.donation.donationId = don.donationId 
    JOIN Currency c ON don.currency.currencyId = c.currencyId 
    GROUP BY e.eventName, e.eventDate, et.eventType, v.firstName, v.phone, c.currencyName
""")
    List<Object[]> getEventVolunteerDonationsByCurrency();
}
