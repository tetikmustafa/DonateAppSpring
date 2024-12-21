package com.example.donateapp.service.impl;

import com.example.donateapp.entity.TaskType;
import com.example.donateapp.repository.TaskTypeRepository;
import com.example.donateapp.service.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskTypeServiceImpl implements TaskTypeService {

    @Autowired
    TaskTypeRepository taskTypeRepository;

    @Override
    public TaskType findById(Long id) {
        return taskTypeRepository.findById(id).orElse(null);
    }
}
