package net.azib.java.students.t104971.chars;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static net.azib.java.students.t104971.chars.ConsoleInput.getLine;

/**
 * @author Jaroslav Judin
 */
public class PersonBuilder {

    static Person createPerson() {
        Person person = new Person();
        while (person.getName() == null) {
            System.out.println("Enter name: ");
            person.setName(validateName(getLine()));
        }
        while (person.getBirthDay() == null) {
            System.out.println("Enter birthday: ");
            person.setBirthDay(validateDate(getLine()));
        }
        while (person.getEmail() == null) {
            System.out.println("Enter email: ");
            person.setEmail(validateEmail(getLine()));
        }
        while (person.getPhone() == null) {
            System.out.println("Enter phone: ");
            person.setPhone(validatePhone(getLine()));
        }
        return person;
    }

    static String validateName(String name) {
        return name.trim().contains(" ") ? name : null;
    }

    static String validateEmail(String email) {
        return email.matches(".+@.+\\..+") ? email : null;
    }

    static String validatePhone(String phone) {
        return phone.matches("[-+ \\d]{7,20}") ? phone : null;
    }

    static Date validateDate(String value) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            String expression = "^[0-3]?[0-9]{1}\\.[0-1]{1}[0-9]{1}\\.[1,2]{1}[0,9]{1}[0-9]{2}$";
            return value.matches(expression) ? format.parse(value) : null;
        } catch (ParseException e) {
            return null;
        }
    }

}
