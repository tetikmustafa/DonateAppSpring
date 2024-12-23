package com.example.donateapp.repository;

import com.example.donateapp.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
/*
    @Modifying
    @Query("INSERT INTO Volunteers (firstName, lastName, phone, taskTypeID) " +
            "VALUES (:firstName, :lastName, :phone, :taskTypeID)")
    void save(@Param("firstName") String firstName,
              @Param("lastName") String lastName,
              @Param("phone") String phone,
              @Param("taskTypeID") Long taskTypeID);

    @Query("SELECT v FROM Volunteers v WHERE v.volunteerId = :volunteerId")
    Volunteer findById(@Param("volunteerId") Long volunteerId);

    @Query("SELECT v FROM Volunteers v")
    List<Volunteer> findAll();

    @Modifying
    @Query("UPDATE Volunteers v SET v.firstName = :firstName, v.lastName = :lastName, " +
            "v.phone = :phone, v.taskTypeID = :taskTypeID WHERE v.volunteerId = :volunteerId")
    void update(@Param("volunteerId") Long volunteerId,
                @Param("firstName") String firstName,
                @Param("lastName") String lastName,
                @Param("phone") String phone,
                @Param("taskTypeID") Long taskTypeID);

    @Modifying
    @Query("DELETE FROM Volunteers v WHERE v.volunteerId = :volunteerId")
    void deleteById(@Param("volunteerId") Long volunteerId);

    @Modifying
    @Query("DELETE FROM Volunteers")
    void deleteAll();

 */

    @Query("""
    SELECT v.firstName, v.lastName, tt.taskName 
    FROM Volunteer v 
    JOIN TaskType tt ON v.taskType.taskTypeId = tt.taskTypeId
""")
    List<Object[]> getVolunteersWithTasks();
}
