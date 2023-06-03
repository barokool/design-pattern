package com.student.observer;

import com.student.entities.Task;

public interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers(Task task);
}
