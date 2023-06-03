package com.student.services;

import com.student.dtos.TaskDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITaskService_command {
    TaskDto getTask(String id);

    TaskDto createTask (TaskDto dto);

    TaskDto updateTask (String id, TaskDto dto);

    TaskDto deleteTask (String id);
    Page<TaskDto> getListTask(Pageable pageable);
}
