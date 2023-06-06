package com.student.observer;

import com.student.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TaskList implements Subject {
    private List<Task> tasks;

    private List<Observer> observers;

    public TaskList() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }
    // Implement Subject interface methods
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Task task) {
        for (Observer observer : observers) {
            observer.update(task);
        }
    }

    // Other methods for managing tasks
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Observe add Task");
        this.notifyObservers(task); // Notify observers when a task is added
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        System.out.println("Observe remove Task");
        this.notifyObservers(task); // Notify observers when a task is removed
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
