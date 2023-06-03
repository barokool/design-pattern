package com.student.controllers;

import com.student.dtos.TaskDto;
import com.student.entities.Task;
import com.student.services.ITaskService;
import com.student.services.impl.TaskService;
import com.student.services.impl.TaskServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    @Qualifier("TaskServiceProxy")
    private ITaskService taskServiceProxy;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto task) {
        taskService.createTask(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PostMapping("/proxy")
    public ResponseEntity<TaskDto> createTaskProxy(@RequestBody TaskDto task) {
        taskServiceProxy.createTask(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<Page<TaskDto>> getAllTasks() {
        Page<TaskDto> tasks = taskService.getListTask(Pageable.ofSize(5));
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

}
