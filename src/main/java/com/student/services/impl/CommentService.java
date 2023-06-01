package com.student.services.impl;

import com.student.dtos.CommentDto;
import com.student.entities.Comment;
import com.student.exceptions.NotFoundException;
import com.student.repositories.CommentRepository;
import com.student.services.ICommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {
    private final CommentRepository CommentRepository;
    @Autowired
    private ModelMapper modelMapper;
    public CommentService(CommentRepository CommentRepository) {
        this.CommentRepository = CommentRepository;
    }


    private Comment setComment(CommentDto dto, Comment Comment) {
        Comment.setAuthor(dto.getAuthor());
        Comment.setDescription(dto.getDescription());
        Comment.setTask(dto.getTask());

        CommentRepository.save(Comment);
        return Comment;
    }

    private Comment getCommentById(String id) {
        return CommentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("không tồn tại", id)));
    }

    @Override
    public CommentDto getComment(String id) {
        Comment Comment = getCommentById(id);
        return modelMapper.map(Comment, CommentDto.class);
    }

    @Override
    public CommentDto createComment(CommentDto dto) {
        Comment Comment = new Comment();
        setComment(dto, Comment);
        return modelMapper.map(Comment, CommentDto.class);
    }

    @Override
    public CommentDto updateComment(String id, CommentDto dto) {
        Comment course = getCommentById(id);
        setComment(dto, course);
        return modelMapper.map(course, CommentDto.class);

    }

    @Override
    public CommentDto deleteComment(String id) {
        Comment Comment = getCommentById(id);
        CommentRepository.delete(Comment);
        return modelMapper.map(Comment, CommentDto.class);
    }

    @Override
    public Page<CommentDto> getListComment(Pageable pageable) {
        return CommentRepository.findAll(pageable).map(Comment -> modelMapper.map(Comment, CommentDto.class));

    }
}
