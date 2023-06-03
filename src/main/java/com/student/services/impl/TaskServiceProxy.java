package com.student.services.impl;

import com.student.dtos.TaskDto;
import com.student.services.ITaskService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("TaskServiceProxy")
public class TaskServiceProxy implements ITaskService {
    private static TaskService object;

    public TaskServiceProxy(TaskService todoService) {
        this.object = todoService;
    }

    @Override
    public TaskDto getTask(String id) {
        return null;
    }

    @Override
    public TaskDto createTask(TaskDto dto) {

        System.out.println("Proxy: Before method invocation");
        TaskDto taskDto= object.createTask(dto);
        System.out.println("Proxy: After method invocation");
        return  taskDto;
    }

    @Override
    public TaskDto updateTask(String id, TaskDto dto) {
        return null;
    }

    @Override
    public TaskDto deleteTask(String id) {
        return null;
    }

    @Override
    public Page<TaskDto> getListTask(Pageable pageable) {
        return null;
    }
}
