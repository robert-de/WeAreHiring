package com.company;

import java.time.LocalDate;

class Experience implements Comparable{
    LocalDate dateBegin;
    LocalDate dateEnd;
    String position;
    String department;
    String company;

    public Experience(String company,  String position,  String department,
                      LocalDate dateBegin, LocalDate dateEnd) throws InvalidDatesException{

        if (dateEnd != null && dateBegin.isAfter(dateEnd))
            throw new InvalidDatesException();

        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.position = position;
        this.company = company;
        this.department = department;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Experience) {
            Experience exp = (Experience) o;
            if (exp.dateEnd != null) {
                if (dateEnd.isBefore(exp.dateEnd))
                    return 1;
                else if (dateEnd.isAfter(exp.dateEnd) )
                    return -1;
                else
                    return company.compareTo(exp.company);
            }

        }
        return 1;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "dateBegin=" + dateBegin +
                ", dateEnd=" + dateEnd +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", company='" + company + '\'' +
                "}\n";
    }
}