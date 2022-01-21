package com.company;

public class Constraint {
    private Double lower;
    private Double upper;

    public Constraint(Double lower, Double upper) {
        this.lower = lower;
        this.upper = upper;
    }

    // metoda folosita pentru calificarea potentialilor angajati
    boolean satisfied (Double value) {
        if (value > upper || value < lower)
            return false;
        return true;
    }
}
