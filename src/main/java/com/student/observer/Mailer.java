package com.student.observer;

import com.student.entities.Task;

public class Mailer implements Observer {
    @Override
    public void update(Task task) {
            System.out.println("Mailer: "+task.getTitle()+" đã được cập nhật");
    }


}