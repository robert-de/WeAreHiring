package com.company;

public interface Observer {
    void update(Notification notification);
}

interface Subject {
    void addObserver(User c);
    void removeObserver(User c);
    void notifyAllObservers();
}