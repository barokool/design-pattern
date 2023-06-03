package com.student.controllers;

import com.student.dtos.TaskDto;
import com.student.services.impl.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author : Viet Van Lau
 * @project design-pattern
 * @created 03/06/2023 - 5:58 PM
 */

@RestController
@RequestMapping("/v1/task")

public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> get(@PathVariable String id) {
        return new ResponseEntity<>(taskService.getTask(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Page<TaskDto>> getList(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<TaskDto> enrollmentPage = taskService.getListTask(pageable);
        return new ResponseEntity<>(enrollmentPage, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TaskDto> create(@Valid @RequestBody TaskDto dto) {
        return new ResponseEntity<>(taskService.createTask(dto), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> update(@PathVariable String id, @Valid @RequestBody TaskDto dto) {
        return new ResponseEntity<>(taskService.updateTask(id, dto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDto> delete(@PathVariable String id) {
        return new ResponseEntity<>(taskService.deleteTask(id), HttpStatus.OK);
    }
}
