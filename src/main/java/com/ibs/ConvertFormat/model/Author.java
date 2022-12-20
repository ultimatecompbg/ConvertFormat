package com.ibs.ConvertFormat.model;

import com.ibs.ConvertFormat.Constants;
import com.ibs.ConvertFormat.service.egnvalidation.Egn;
import org.springframework.validation.annotation.Validated;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Author {
    private String name;
    private String surname;
    private String familyName;
    private Date birthDate;
    private String egn;
    public Author(){

    }
    public Author(String name, String surname, String familyName, String newBirthDate, String egn) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.familyName = familyName;
        Date birthDate = new SimpleDateFormat(Constants.dateFormat).parse(newBirthDate);
        this.birthDate = birthDate;
        this.egn = egn;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String newBirthDate) throws ParseException {
        Date birthDate = new SimpleDateFormat(Constants.dateFormat).parse(newBirthDate);
        this.birthDate = birthDate;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
            this.egn = egn;
    }
    @Override
    public String toString() {
        String authorString = String.format("Name: %s %s %s\nBirthdate: %s\nSSN: %s", name, surname, familyName, birthDate, egn);
        return authorString;
    }
}
