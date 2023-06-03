package com.student.factories.impl;


import com.student.dtos.CommentDto;
import com.student.entities.Comment;
import com.student.entities.Task;
import com.student.factories.CreateEntity;

/**
 * @author : Viet Van Lau
 * @project design-pattern
 * @created 03/06/2023 - 5:39 PM
 */
public class CommentImlp implements CreateEntity<Comment, CommentDto> {
        @Override
        public Comment create(CommentDto dto) {
                return new Comment(dto.getDescription(), dto.getTask(), dto.getAuthor());
        }
}