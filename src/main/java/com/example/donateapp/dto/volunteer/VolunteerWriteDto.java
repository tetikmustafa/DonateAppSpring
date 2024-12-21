package com.example.donateapp.dto.volunteer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VolunteerWriteDto {

    private String firstName;
    private String lastName;
    private String phone;
    private Long taskTypeId; // service layer will set this field

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

    public Long getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Long taskTypeId) {
        this.taskTypeId = taskTypeId;
    }
}
