package net.azib.java.students.t103640.chars;

import java.util.Scanner;
//TODO  validating input information.
public class ContactListBuilder {

    static Person createOnePerson(Person person){

        while(person.getName() == null){
            System.out.println("Please enter the name of the contact");
            person.setName(new Scanner(System.in).next());
        }
       //System.out.println(person.getName());
       while(person.getBirthday() == null){
           System.out.println("Please enter the birthday of the contact");
        person.setBirthday(new Scanner(System.in).next());
       }
        while(person.getEmail() == null){
            System.out.println("Please enter the email of the contact");
            person.setEmail(new Scanner(System.in).next());
        }
        while(person.getPhoneNumber() == 0){
            System.out.println("Please enter the phone number of the contact");
            person.setPhoneNumber(Integer.parseInt(new Scanner(System.in).next()));
        }
        System.out.println(person.getPhoneNumber());
        return person;
    }
}
