package com.company;

public class Employee extends Consumer {
    private String companyName ;
    private int salariu;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public Employee(String companyName, int salariu) {
        this.companyName = companyName;
        this.salariu = salariu;
    }

    public Employee() {
        this("nocom", 0);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "companyName='" + companyName + '\'' +
                ", salariu=" + salariu +
                '}';
    }
}
