package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Department {
    private String name;
    private ArrayList<Employee> employees;
    private ArrayList<Job> availableJobs;

    public String getName() {
        return name;
    }

    public Department(String name, ArrayList<Employee> employees, ArrayList<Job> availableJobs) {
        this.name = name;
        this.employees = employees;
        this.availableJobs = availableJobs;
    }

    public abstract double getTotalSalaryBudget();

    public ArrayList<Job> getJobs() {
        return availableJobs;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove (Employee employee) {
        int i = employees.indexOf(employee);
        if (i > -1)
            employees.remove(i);

        // adaugarea unei date de incheiere in momentul concedierii
        employee.resume.experience.get(employee.resume.experience.size() - 1).dateEnd = LocalDate.now();

    }

    public void add(Job job) {
        availableJobs.add(job);
        Iterator itty = job.candidates.iterator();
        User user;
        // notific pe cei interesati de adaugarea unui nou job la compania dorita
        while (itty.hasNext()){
            user = (User) itty.next();
            user.update(new Notification("New job: " + job.jobName + " at " + job.companyName + " !"));
        }

    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
