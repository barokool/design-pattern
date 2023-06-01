package com.student.repositories;

import com.student.entities.Category;
import com.student.entities.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {
}
