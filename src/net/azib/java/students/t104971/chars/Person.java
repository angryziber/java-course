package net.azib.java.students.t104971.chars;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jaroslav Judin
 */
public class Person {

    String name;
    Date birthDay;
    String email;
    String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person {" +
                "\n\tname='" + name + '\'' +
                "\n\tbirthDay=" + new SimpleDateFormat("dd.MM.yyyy").format(birthDay) +
                "\n\temail='" + email + '\'' +
                "\n\tphone='" + phone + '\'' +
                "\n}";
    }
}
