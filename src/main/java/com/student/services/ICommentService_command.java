package com.student.services;

import com.student.dtos.CommentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICommentService_command {

    CommentDto getComment(String id);

    CommentDto createComment (CommentDto dto);

    CommentDto updateComment(String id, CommentDto dto);

    CommentDto deleteComment(String id);
    Page<CommentDto> getListComment(Pageable pageable);
}
