package com.student.dtos;

import com.student.entities.Account;
import com.student.entities.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private String id;
    private String description;
    @DBRef
    private Task task;
    @DBRef
    private Account author;
}
