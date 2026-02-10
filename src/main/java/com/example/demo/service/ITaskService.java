package com.example.demo.service;

import com.example.demo.model.dto.GenericResponse;
import com.example.demo.model.dto.TaskDto;

import java.util.List;

public interface ITaskService {
    GenericResponse<List<TaskDto>> getAll();
    GenericResponse<TaskDto> create(TaskDto task);
    GenericResponse<TaskDto> update(TaskDto task);
    GenericResponse<Long> delete(Long id);
}
