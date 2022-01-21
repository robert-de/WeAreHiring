package com.company;

import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;

public class Company implements Subject{
    ArrayList<Observer> observers;
    String name;
    Manager manager;
    ArrayList<Department> departments;
    ArrayList<Recruiter> recruiters;

    public Company() {
        observers = new ArrayList<Observer>();
        departments = new ArrayList<Department>();
        recruiters = new ArrayList<Recruiter> ();
    }

    public void add (Department department) {
        departments.add(department);
    }

    public void add(Recruiter recruiter) {
        recruiters.add(recruiter);
    }

    public void add(Employee employee, Department department) {
        if (departments.contains(department)) {
            Department dep = departments.get(departments.indexOf(department));
            dep.add(employee);
        }
        else {
            department.add(employee);
            departments.add(department);
        }
    }

    public void remove(Employee employee) {
        Iterator itty = departments.iterator();
        Department dep;

        while (itty.hasNext()){
            dep = (Department) itty.next();
            dep.remove(employee);
        }
    }

    public void remove(Department department) {
        int i = departments.indexOf(department);
        if (i > -1)
            departments.remove(i);
    }

    public void remove (Recruiter recruiter) {
        int i = recruiters.indexOf(recruiter);
        if (i > -1)
            recruiters.remove(i);
    }

    public void move (Department source, Department destination) {
        ArrayList<Employee> srcEmployees = source.getEmployees();
        Iterator itty = srcEmployees.iterator();
        Employee emp;

        while (itty.hasNext()){
            emp = (Employee) itty.next();
            destination.add(emp);
        }
    }

    public void move (Employee employee, Department newDepartment) {
        departments.remove(employee);
        newDepartment.add(employee);
    }

    public boolean contains (Department department) {
        return departments.contains(department);
    }

    public boolean contains (Employee employee) {

        Iterator itty = departments.iterator();
        Department dep;

        while (itty.hasNext()){
            dep = (Department) itty.next();
            if(dep.getEmployees().contains(employee))
                return true;
        }

        return false;
    }

    public Recruiter getRecruiter(User user) {
        Iterator itty = recruiters.iterator();
        Recruiter rec;
        Recruiter bestRecruiter = recruiters.get(0);
        itty.next();

        while (itty.hasNext()){
            rec = (Recruiter) itty.next();
            if (rec.getDegreeInFriendship(user) > bestRecruiter.getDegreeInFriendship(user))
                bestRecruiter = rec;
            else if (rec.getDegreeInFriendship(user) == bestRecruiter.getDegreeInFriendship(user))
                if (rec.rating > bestRecruiter.rating)
                    bestRecruiter = rec;

        }

        return bestRecruiter;
    }

    public ArrayList<Job> getJobs() {
        Iterator itty = departments.iterator();
        Department dep;
        ArrayList<Job> allJobs = new ArrayList<Job>();

        while (itty.hasNext()){
            dep = (Department) itty.next();
            allJobs.addAll(dep.getJobs());
        }

        return allJobs;
    }
    // metoda nou adaugata pentru determinarea unui departament in metoda process()
    public Department getJobDepartment(Job job) {
        Iterator itty = departments.iterator();
        Department dep;
        while (itty.hasNext()) {
            dep = (Department) itty.next();
            if (dep.getJobs().contains(job)) {
                return dep;
            }
        }
        return null;
    }

    @Override
    public void addObserver(User c) {
        observers.add(c);
    }

    @Override
    public void removeObserver(User c) {
        observers.remove(c);
    }

    @Override
    public void notifyAllObservers() {
        Notification notification = new Notification("Shareholder meeting in a week!");
    }
}
