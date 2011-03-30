package net.azib.java.students.t104971.chars;

import org.apache.log4j.BasicConfigurator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jaroslav Judin
 */
public class Contacts {

    List<Person> friends = new ArrayList<Person>();
    private PersonBuilder personBuilder;
    private ConsoleInput console;

    public static void main(String[] args) {
        new Contacts().run();
    }

    public void run() {
        BasicConfigurator.configure();

        setPersonBuilder(new PersonBuilder());
        setConsole(new ConsoleInput());
        buildContactsList();
        printPersons();
    }

    void buildContactsList() {
        boolean stop;
        do {
            friends.add(getPersonBuilder().createPerson());
            System.out.println("Do you want to stop entering friends?");
            stop = getConsole().getLine().equalsIgnoreCase("yes");
        } while (!stop);
    }

    private void printPersons() {
        System.out.println("List of friends:");
        for (Person person : friends) {
            System.out.println(person);
        }
    }

    public PersonBuilder getPersonBuilder() {
        return personBuilder;
    }

    public void setPersonBuilder(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
    }

    public ConsoleInput getConsole() {
        return console;
    }

    public void setConsole(ConsoleInput console) {
        this.console = console;
    }
}
