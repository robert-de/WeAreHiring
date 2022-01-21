package com.company;

import java.util.ArrayList;

public class Job {
    String jobName;
    String companyName;
    boolean available;

    Constraint gradYear;
    Constraint yrsOfExperience;
    Constraint grades;

    ArrayList<User> candidates;
    int noPositions;
    int salary;

    public void apply(User user) {
        if (available) {
            Company momCompany = Application.getInstance().getCompany(companyName);
            Recruiter recruiter = momCompany.getRecruiter(user);
            recruiter.evaluate(this, user);
        }
    }


    public boolean meetsRequirements (User user) {
        Double grFromInt = user.getGraduationYear().doubleValue();
        if(!gradYear.satisfied(grFromInt))
            return false;
        if (!yrsOfExperience.satisfied(user.resume.yearsExperience()))
            return false;
        if (!grades.satisfied(user.meanGPA()))
            return false;

        return true;
    }

}
