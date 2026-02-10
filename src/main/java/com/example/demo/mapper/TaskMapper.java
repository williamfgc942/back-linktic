package com.example.demo.mapper;

import com.example.demo.model.dto.TaskDto;
import com.example.demo.model.entity.TaskEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto map(TaskEntity entity);
    List<TaskDto> mapListDto(List<TaskEntity> entity);
    TaskEntity map(TaskDto task);
    List<TaskEntity> mapListEntity(List<TaskDto> task);
}
