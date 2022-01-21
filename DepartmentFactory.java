package com.company;

import java.util.ArrayList;

public class DepartmentFactory {
        public static Department createUser(String name, ArrayList<Employee> employees, ArrayList<Job> availableJobs ){
            if(name.equals("IT")){
                return new IT(name, employees, availableJobs );
            }
            else if(name.equals("Marketing")){
                return new Marketing(name, employees, availableJobs);
            }
            else if(name.equals("Finance")){
                return new Finance(name, employees, availableJobs );
            }
            else if(name.equals("Management")){
                return new Management(name, employees, availableJobs);
            }
            return null;
        }

}
