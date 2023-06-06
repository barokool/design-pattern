package com.student.services.impl;

import com.student.dtos.TaskDto;
import com.student.entities.Task;
import com.student.exceptions.NotFoundException;
import com.student.observer.TaskList;
import com.student.repositories.TaskRepository;
import com.student.services.ITaskService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private  TaskRepository TaskRepository;
    @Autowired
    private  TaskList taskList;

    @Autowired
    private ModelMapper modelMapper;
    public TaskService() {

    }

    @Override
    public TaskDto createTask(TaskDto dto) {
        Task Task = new Task();
        setTask(dto, Task);
        taskList.addTask(Task);
        return modelMapper.map(Task, TaskDto.class);
    }

    private Task setTask(TaskDto dto, Task Task) {
        Task.setUser(dto.getUser());
        Task.setDescription(dto.getDescription());
        Task.setTitle(dto.getTitle());
        Task.setCategory(dto.getCategory());
        Task.setStatus(dto.getStatus());

        TaskRepository.save(Task);
        return Task;
    }

    private Task getTaskById(String id) {
        return TaskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("không tồn tại", id)));
    }

    @Override
    public TaskDto getTask(String id) {
        Task Task = getTaskById(id);
        return modelMapper.map(Task, TaskDto.class);
    }



    @Override
    public TaskDto updateTask(String id, TaskDto dto) {
        Task course = getTaskById(id);
        setTask(dto, course);
        return modelMapper.map(course, TaskDto.class);

    }

    @Override
    public TaskDto deleteTask(String id) {
        Task Task = getTaskById(id);
        TaskRepository.delete(Task);
        taskList.removeTask(Task);
        return modelMapper.map(Task, TaskDto.class);
    }

    @Override
    public Page<TaskDto> getListTask(Pageable pageable) {
        return TaskRepository.findAll(pageable).map(Task -> modelMapper.map(Task, TaskDto.class));

    }
}
