package com.student.factories.impl;

import com.student.dtos.TaskDto;
import com.student.entities.Task;
import com.student.factories.CreateEntity;

/**
 * @author : Viet Van Lau
 * @project design-pattern
 * @created 03/06/2023 - 4:29 PM
 */
public class TaskImpl implements CreateEntity<Task, TaskDto> {
    @Override
    public Task create(TaskDto dto) {
        return new Task(dto.getUser(), dto.getDescription(), dto.getTitle(), dto.getCategory(),dto.getStatus());
    }
}
