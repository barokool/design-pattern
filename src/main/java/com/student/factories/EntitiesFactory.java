package com.student.factories;

import com.student.dtos.AccountDto;
import com.student.dtos.CategoryDto;
import com.student.dtos.CommentDto;
import com.student.dtos.TaskDto;
import com.student.entities.Account;
import com.student.entities.Category;
import com.student.entities.Comment;
import com.student.entities.Task;
import com.student.factories.impl.AccountImpl;
import com.student.factories.impl.CategoryImlp;
import com.student.factories.impl.CommentImlp;
import com.student.factories.impl.TaskImpl;

/**
 * @author : Viet Van Lau
 * @project design-pattern
 * @created 03/06/2023 - 4:03 PM
 */
public class EntitiesFactory<T,D> {
    public final CreateEntity<T,D> createEntity(D dto) {
        if (dto == null) {
            return null;
        }
        if (dto instanceof AccountDto) {
            return (CreateEntity<T,D> ) new AccountImpl();
        } else if (dto instanceof TaskDto) {
            return (CreateEntity<T,D> ) new TaskImpl();
        }
        else if (dto instanceof CategoryDto) {
            return (CreateEntity<T,D> ) new CategoryImlp();
        }
        else if (dto instanceof CommentDto) {
            return (CreateEntity<T,D> ) new CommentImlp();
        }
        return null;
    }
}

//        public static Account createAccount(AccountDto dto) {
//            return new Account.AccountBuilder().setName(dto.getName().trim()).setGender(dto.getGender().trim()).setDateOfBirth(dto.getDateOfBirth()).setEmail(dto.getEmail().trim()).setPassword(dto.getPassword().trim()).build();
//        }
//
//        public static Task createTask(TaskDto dto) {
//            return new Task(dto.getUser(), dto.getDescription(), dto.getTitle(), dto.getCategory(),dto.getStatus());
//        }
//
//        public static Category createCategory(String title, String description) {
//            return new Category(title, description);
//        }
//        public static Comment createComment(String content, String sender, Date timestamp) {
//            return new Comment(content, sender, timestamp);
//        }
