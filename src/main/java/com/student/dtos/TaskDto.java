package com.student.dtos;

import com.student.entities.Account;
import com.student.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private String id;
    private String title;
    private String description;
    private String status;
    @DBRef
    private Category category;
    @DBRef
    private Account user;
}
