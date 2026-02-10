package com.example.demo.controller;

import com.example.demo.model.dto.GenericResponse;
import com.example.demo.model.dto.TaskDto;
import com.example.demo.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @GetMapping
    public GenericResponse<List<TaskDto>> getAll() {
        return taskService.getAll();
    }

    @PostMapping
    public GenericResponse<TaskDto> create(@RequestBody TaskDto task) {
        return taskService.create(task);
    }

    @PutMapping
    public GenericResponse<TaskDto> update(@RequestBody TaskDto task) {
        return taskService.update(task);
    }

    @DeleteMapping("/{id}")
    public GenericResponse<Long> delete(@PathVariable Long id) {
        return taskService.delete(id);
    }
}