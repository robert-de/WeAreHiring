package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Finance extends Department {

    public Finance(String name, ArrayList<Employee> employees, ArrayList<Job> availableJobs) {
        super(name, employees, availableJobs);
    }

    public double getTotalSalaryBudget() {
        double totalSalary = 0;
        Iterator itty = getEmployees().iterator();
        Employee employee;

        while (itty.hasNext()) {
            employee = (Employee) itty.next();
            if (employee.resume.yearsExperience() > 1)
                totalSalary += employee.getSalariu() / 0.9;
            else
                totalSalary += employee.getSalariu() / 0.84;
        }

        return  totalSalary / 0.84;
    }

}
