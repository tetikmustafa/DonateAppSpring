package com.example.donateapp.controller;

import com.example.donateapp.dto.volunteer.VolunteerReadDto;
import com.example.donateapp.dto.volunteer.VolunteerWriteDto;
import com.example.donateapp.serviceview.VolunteerServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("api/volunteers")
public class VolunteerController {

    @Autowired
     VolunteerServiceView volunteerServiceView;

    @PostMapping()
    public ResponseEntity<VolunteerReadDto> save(@RequestBody VolunteerWriteDto volunteerWriteDto) {
        return new ResponseEntity<>(volunteerServiceView.save(volunteerWriteDto), HttpStatus.CREATED);
    }

    @GetMapping("/{volunteerId}")
    public ResponseEntity<VolunteerReadDto> findById(@PathVariable Long volunteerId) {
        return new ResponseEntity<>(volunteerServiceView.findById(volunteerId), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<VolunteerReadDto>> findAll() {
        return new ResponseEntity<>(volunteerServiceView.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{volunteerId}")
    public ResponseEntity<VolunteerReadDto> update(@RequestBody VolunteerWriteDto volunteerWriteDto, @PathVariable Long volunteerId) {
        return new ResponseEntity<>(volunteerServiceView.update(volunteerWriteDto, volunteerId), HttpStatus.OK);
    }

    @DeleteMapping("/{volunteerId}")
    public ResponseEntity<String> deleteById(@PathVariable Long volunteerId) {
        volunteerServiceView.deleteById(volunteerId);
        return new ResponseEntity<>("Volunteer with id " + volunteerId + " has been deleted", HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAll() {
        volunteerServiceView.deleteAll();
        return new ResponseEntity<>("All volunteers have been deleted", HttpStatus.OK);
    }

    @GetMapping("/volunteersWithTasks")
    public ResponseEntity<Object> getVolunteersWithTasks() {
        return new ResponseEntity<>(volunteerServiceView.getVolunteersWithTasks(), HttpStatus.OK);
    }
}
