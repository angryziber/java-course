package net.azib.java.students.t104971.chars;

import org.apache.log4j.BasicConfigurator;

import java.util.ArrayList;
import java.util.List;

import static net.azib.java.students.t104971.chars.ConsoleInput.getLine;
import static net.azib.java.students.t104971.chars.PersonBuilder.createPerson;

/**
 * @author Jaroslav Judin
 */
public class Contacts {

    private static List<Person> friends = new ArrayList<Person>();

    public static void main(String[] args) {
        BasicConfigurator.configure();

        buildContactsList();

        printPersons();
    }

    private static void buildContactsList() {
        boolean stop;
        do {
            friends.add(createPerson());
            System.out.println("Do you want to stop entering friends?");
            stop = getLine().equalsIgnoreCase("yes");
        } while (!stop);
    }

    private static void printPersons() {
        System.out.println("List of friends:");
        for(Person person : friends) {
            System.out.println(person);
        }
    }


}
