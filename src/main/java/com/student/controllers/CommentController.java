package com.student.controllers;

import com.student.dtos.CommentDto;
import com.student.services.impl.CommentService;
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
 * @created 03/06/2023 - 6:04 PM
 */

@RestController
@RequestMapping("/v1/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> get(@PathVariable String id) {
        return new ResponseEntity<>(commentService.getComment(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Page<CommentDto>> getList(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<CommentDto> enrollmentPage = commentService.getListComment(pageable);
        return new ResponseEntity<>(enrollmentPage, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CommentDto> create(@Valid @RequestBody CommentDto dto) {
        return new ResponseEntity<>(commentService.createComment(dto), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable String id, @Valid @RequestBody CommentDto dto) {
        return new ResponseEntity<>(commentService.updateComment(id, dto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable String id) {
        return new ResponseEntity<>(commentService.deleteComment(id), HttpStatus.OK);
    }
}
