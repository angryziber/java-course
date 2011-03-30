package net.azib.java.students.t103640.chars;

import java.util.ArrayList;
import java.util.Scanner;

import static net.azib.java.students.t103640.chars.ContactListBuilder.createOnePerson;

public class Contacts {
    public int numberOfContacts;


    public static void main(String[] args) {
           new Contacts();
      }
    public Contacts(){
        greetings();
        input();
        createListOfContacts(numberOfContacts);


    }

    private void output(ArrayList<Person> contactList) {
        System.out.println("So, if I programmed this correctly, the results should be here: ");
        for(Person a: contactList){
           System.out.println(a.getName());
           System.out.println(a.getBirthday());
           System.out.println(a.getPhoneNumber());
           System.out.println(a.getEmail());
        }

        }


    private void createListOfContacts(int numberOfContacts) {
        ArrayList<Person> contactList = new ArrayList<Person>();
        int i=0;
        Person newPerson;
        while(i<numberOfContacts){
            newPerson = new Person();
            createOnePerson(newPerson);
            contactList.add(newPerson);
            i++;
         }
        output(contactList);
    }


    private void input() {
        System.out.println("REMEMBER: This program expects you, the user, to be intelligent,");
        System.out.println("so PLEASE do not enter for your birthday something like: YELLOW!");
        System.out.println("Please enter the number of contacts you wish to enter!");
        numberOfContacts = Integer.parseInt(new Scanner(System.in).next());
    }

    public void greetings(){

        System.out.println("Hello, thank you for running my program");
        System.out.println("Today we shall create you a contact list");
        System.out.println("How exciting!!!");

    }

}