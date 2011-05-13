package net.azib.java.students.t107678.homework;

import java.util.Date;

public class Participant {

    private String name;
    private Date birthDate;
    private CountryCode country;

public Participant(String name, Date birthDate, CountryCode country) {
       this.name = name;
        this.birthDate = birthDate;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public CountryCode getCountry() {
        return country;
    }
}
