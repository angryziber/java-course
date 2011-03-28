package net.azib.java.students.t103640.chars;

import java.util.Scanner;
//TODO Improve validating input information.
public class ContactListBuilder {

    static Person createOnePerson(){
        Person person = new Person();
        while(person.getName() == null){
            System.out.println("Please enter the name of the contact");
            person.setName(new Scanner(System.in).next());
        }
       //System.out.println(person.getName());
       while(person.getBirthday() == null){
           System.out.println("Please enter the birthday of the contact");
      //TODO find out how to fix that: person.setBirthday(new Scanner(System.in).next());
       }
        return person;
    }
}
