package com.company;

import java.util.ArrayList;

public class Information {
    private String nume;
    private String prenume;
    private String email;
    private String telefon;
    private String dataNastere;
    private String sex;
    private ArrayList<String> languages;
    private ArrayList<String> qualifications;

    public Information() {
        ArrayList languages = new ArrayList<String>();
        ArrayList qualifications = new ArrayList<String>();
    }

    void setNumePrenume(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    String getNumePrenume() {
        return nume + " " + prenume;
    }

    void setEmail (String email) {
        this.email = email;
    }
    void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    void setDataNastere(String dataNastere) {
        this.dataNastere = dataNastere;
    }
    void setSex(String sex) {
        this.sex = sex;
    }

    void addCertification (String language, String level) {
        languages.add(language);
        qualifications.add(level);
    }

    ArrayList<String> getLanguages() {
        return languages;
    }

    ArrayList<String> getQualifications() {
        return qualifications;
    }

    String getEmail () {
        return email;
    }

    String getTelefon() {
        return telefon;
    }

    String getDataNastere() {
        return dataNastere;
    }

    String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "\n Information{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", dataNastere='" + dataNastere + '\'' +
                ", sex='" + sex + '\'' +
                ", languages=" + languages +
                ", qualifications=" + qualifications +
                "}\n";
    }
}
