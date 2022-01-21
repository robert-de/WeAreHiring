package com.company;

public class Notification {
    String message;

    public Notification(String s) {
        message = s;
    }

    public Notification(Company c) {
        message = "Company " + c.name + " just added a new job listing!";
    }

    public String toString() {
        return message;
    }
}
