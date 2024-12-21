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
@Table(name = "volunteers")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VolunteerID")
    private Long volunteerId;

    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "TaskTypeID", nullable = false)
    private TaskType taskType;


    @OneToMany(mappedBy = "volunteer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VolunteerEvent> volunteerEvents;

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }
}
