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
@Document(collection = "task")
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private String status;
    @DBRef
    private Category category;

    @DBRef
    private Account user;

    public Task(Account user, String description, String title, Category category, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.category = category;
        this.user = user;
    }
}
