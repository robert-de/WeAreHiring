package com.company;

import java.util.ArrayList;

public class User extends Consumer implements Observer {
    ArrayList<String> interests = new ArrayList<String>();
    ArrayList<Notification> notifications = new ArrayList<Notification>();

    public Employee convert() {
        Employee emp = new Employee();
        emp.resume = resume;
        emp.knownPpl = knownPpl;

        Application.getInstance().remove(this); // elimin instanta utilizatorului odata ce employee a fost creat
        return emp;
    }

    public Double getTotalScore() {
        Double score = 0d;
        score = resume.yearsExperience() * 1.5 + meanGPA();
        return score;
    }

    @Override
    public void update(Notification notification) {
        notifications.add(notification);
        System.out.println(notification.message);
    }

    @Override
    public String toString() {
        return "User{" +
                "interests=" + interests +
                ", notifications=" + notifications +
                ", resume=" + resume +
                '}';
    }
}
