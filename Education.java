package com.company;

import java.time.LocalDate;

class InvalidDatesException extends Exception {
    public InvalidDatesException() {
        super("Invalid Dates!");
    }
}

public class Education implements Comparable  {
    LocalDate dateBegin;
    LocalDate dateEnd;
    String institutionName;
    String edLevel;
    float medieAbsolvire;

    public Education(LocalDate dateBegin, LocalDate dateEnd,
                     String institutionName, String edLevel, float medieAbsolvire ) throws InvalidDatesException {
        if (dateEnd != null) {
            if (dateEnd.isBefore(dateEnd))
                throw new InvalidDatesException();
            else {
                this.dateBegin = dateBegin;
                this.dateEnd = dateEnd;
                this.institutionName = institutionName;
                this.edLevel = edLevel;
                this.medieAbsolvire = medieAbsolvire;
            }
        }
        else {

        }
    }

    boolean hasGraduated() {
        if (dateEnd == null) {
            return false;
        } else return true;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Education) {
            Education edu = (Education) o;
            if (hasGraduated() && edu.hasGraduated()) {
                if (dateEnd.isBefore(edu.dateEnd))
                    return 1;
                else if (dateEnd.isAfter(edu.dateEnd) )
                    return -1;
                else {
                    if (medieAbsolvire > edu.medieAbsolvire)
                        return -1;
                    else
                        return 1;
                }
            }
            else {
                if (dateBegin.isBefore(edu.dateBegin))
                    return 1;
                else if (dateBegin.isAfter(edu.dateBegin) )
                    return -1;
            }
        }
        return 1; // obiectele straine sunt puse la sfarsitul listei
    }

    @Override
    public String toString() {
        return "Education{" +
                "dateBegin=" + dateBegin +
                ", dateEnd=" + dateEnd +
                ", institutionName='" + institutionName + '\'' +
                ", edLevel='" + edLevel + '\'' +
                ", medieAbsolvire=" + medieAbsolvire +
                "}\n";
    }
}
