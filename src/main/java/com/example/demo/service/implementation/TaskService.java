package com.example.demo.service.implementation;

import com.example.demo.mapper.TaskMapper;
import com.example.demo.model.dto.GenericResponse;
import com.example.demo.model.dto.TaskDto;
import com.example.demo.model.entity.TaskEntity;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public GenericResponse<List<TaskDto>> getAll() {
        GenericResponse<List<TaskDto>> response = new GenericResponse<>();
        response.setResult(taskMapper.mapListDto(taskRepository.findAll()));
        return response;
    }

    @Override
    public GenericResponse<TaskDto> create(TaskDto task) {
        GenericResponse<TaskDto> response = new GenericResponse<>();
        response.setResult(taskMapper.map(taskRepository.save(taskMapper.map(task))));
        response.setMessage("Saved correctly");
        return response;
    }

    @Override
    public GenericResponse<TaskDto> update(TaskDto task) {
        Optional<TaskEntity> taskEntity = taskRepository.findById(task.getId());
        GenericResponse<TaskDto> response = new GenericResponse<>();
        if (taskEntity.isEmpty()) {
            response.setMessage("Task does not exist");
            return response;
        }
        taskEntity.get().setCompleted(task.isCompleted());
        taskEntity.get().setDescription(task.getDescription());
        taskEntity.get().setTitle(task.getTitle());
        response.setResult(taskMapper.map(taskRepository.save(taskEntity.get())));
        return response;
    }

    @Override
    public GenericResponse<Long> delete(Long id) {
        Optional<TaskEntity> taskEntity = taskRepository.findById(id);
        taskRepository.delete(taskEntity.get());
        GenericResponse<Long> response = new GenericResponse<>();
        response.setResult(id);
        return response;
    }
}
