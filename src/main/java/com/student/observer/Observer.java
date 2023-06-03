package com.student.observer;

import com.student.entities.Task;

public interface Observer {
    void update(Task task);
}
