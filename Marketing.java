package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Marketing extends Department{
    public Marketing(String name, ArrayList<Employee> employees, ArrayList<Job> availableJobs) {
        super(name, employees, availableJobs);
    }

    @Override
    public double getTotalSalaryBudget() {
        double totalSalary = 0;
        double salariu;
        Iterator itty = getEmployees().iterator();
        Employee employee;

        while (itty.hasNext()) {
            employee = (Employee) itty.next();
            salariu = employee.getSalariu();
            if (salariu < 3000)
                totalSalary += salariu;
            else if (salariu > 5000)
                totalSalary += salariu / 0.9;
            else
                totalSalary += salariu / 0.84;
        }

        return totalSalary;
    }
}
