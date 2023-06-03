package com.student.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comment")

public class Comment {

    @Id
    private String id;
    private String description;
    @DBRef
    private Task task;

    @DBRef
    private Account author;

    public Comment(String description, Task task, Account author) {
        this.description = description;
        this.task = task;
        this.author = author;
    }

}
