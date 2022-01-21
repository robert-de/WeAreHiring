package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        User user1 = new User();
        Information info1 = new Information();


        try {
            Consumer.Resume.ResumeBuilder builder = new Consumer.Resume.ResumeBuilder()
                    .numePrenume("Morgan", "Rin")
                    .email("say@gmail.com")
                    .telefon("05237122132")
                    .dataNastere("01.03.1980")
                    .sex("male")
                    .education(new Education( LocalDate.of(1985, 10, 23)
                            ,  LocalDate.of(1990, 6, 17), "UPB", "licenta",
                            (float) 5.45))
                    .experience(new Experience("IBM", "CTO", "IT", LocalDate.of(1990, 10, 23),
                            LocalDate.of(1997, 10, 23)));

            user1.resume = builder.build();
            System.out.println(user1);



        } catch (ResumeIncompleteException | InvalidDatesException e) {
            e.printStackTrace();
        }

        System.out.println(user1.convert());
    }
}


class Application {
    private static Application obj = null;
    private ArrayList<Company> comList;
    private ArrayList<User> userList;

    public static Application getInstance() {
        if (obj == null)
            obj = new Application();
        return obj;
    }

    private Application() {
        comList = new ArrayList<Company>();
        userList = new ArrayList<User>();
    }

    public ArrayList<Company> getCompanies() {
        return comList;
    }

    public Company getCompany(String name) {
        Iterator itty = comList.iterator();
        Company tryCom;
        while (itty.hasNext()) {
            tryCom = (Company) itty.next();
            if (tryCom.name == name) {
                return tryCom;
            }
        }
        return null;
    }

    public void add(Company company) {
        comList.add(company);
    }

    public void add(User user) {
        userList.add(user);
    }

    public boolean remove (Company company) {
        if(comList.contains(company)) {
            comList.remove(company);
            return true;
        }
        return false;
    }

    public boolean remove (User user) {
        if(userList.contains(user)) {
            comList.remove(user);
            return true;
        }
        return false;
    }

    public ArrayList<Job> getJobs (ArrayList<String> companies) {
        ArrayList<Job> available = new ArrayList<Job>();

        Iterator itty = companies.iterator();
        Company company;

        while (itty.hasNext()) {
            company = Application.getInstance().getCompany((String) itty.next());
            available.addAll(company.getJobs());
        }
        return available;
    }

    // metoda folosita pentru a verifica stadiul de angajare al unui consumator
    boolean hasUser(User user) {
        return userList.contains(user);
    }
}







