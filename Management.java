package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Management extends Department {
    public Management(String name, ArrayList<Employee> employees, ArrayList<Job> availableJobs) {
        super(name, employees, availableJobs);
    }

    public double getTotalSalaryBudget() {
        double totalSalary = 0;
        Iterator itty = getEmployees().iterator();
        Employee employee;

        while (itty.hasNext()) {
            employee = (Employee) itty.next();
            totalSalary += employee.getSalariu();
        }

        return  totalSalary / 0.84;
    }
}
