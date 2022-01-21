package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Manager extends Employee {
    ArrayList<Request> requests;

    public void process(Job job) {
        ArrayList<Request> validRequests = new ArrayList<Request>();
        Iterator itty = requests.iterator();
        Request request;
        Company momCompany = Application.getInstance().getCompany(getCompanyName());
        Department targetDepartment = momCompany.getJobDepartment(job);

        while (itty.hasNext()) {
            request = (Request) itty.next();
            if (request.getKey().equals(job)) {
                validRequests.add(request);
            }
        }

        Collections.sort(validRequests);
        itty = validRequests.iterator();

        // cat timp locurile disponibile nu au fost epuizate si mai sunt requests
        while (job.noPositions > 0 && itty.hasNext()) {
            request = (Request) itty.next();
            if (Application.getInstance().hasUser((User)request.getValue1())){

                Employee newEmployee = ((User) request.getValue1()).convert();
                newEmployee.setCompanyName(getCompanyName());
                newEmployee.setSalariu(((Job)request.getKey()).salary);

                try {
                    Experience newExperience = new Experience(getCompanyName(), job.jobName,
                            targetDepartment.getName(), LocalDate.now(), null);
                    newEmployee.add(newExperience);
                } catch (InvalidDatesException e) {
                    System.out.println("Error reading current time!");
                }

                momCompany.add(newEmployee, targetDepartment);
                job.noPositions -= 1;
            }
            requests.remove(request); // sterg cererile procesate
        }
        // notific cei ale caror aplicatii nu au fost suficient de bune, daca este cazul
        while (itty.hasNext()) {
            request = (Request) itty.next();
            User user = ((User)request.getValue1());
            user.update(new Notification("Unfortunately, your appplication for " + job.jobName + " at "
                    + job.companyName + "has been rejected"));
        }

        if (job.noPositions == 0) // daca numarul de locuri disponibile au fost satisfacute
            targetDepartment.getJobs().remove(job); // sterg jobul disponibil
    }
}
