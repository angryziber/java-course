package net.azib.java.students.t110013.hometask6;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author Vadim
 */
public class Contacts {
	private SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);
	private List<Person> contacts = new ArrayList<Person>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Contacts contacts = new Contacts();

		contacts.buildContactList(scanner);
		System.out.println(contacts.toString());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("\nCONTACT LIST");
		for (Person person : contacts) {
			sb.append("\n").append(person.toString());
		}
		return sb.toString();
	}

	public void buildContactList(Scanner scanner) {
		boolean proceed = true;
		do {
			addPerson(buildPerson(new Person(), scanner));
			System.out.print("Do you want to add more friends to your contact list (yes/no)? ");
			proceed = scanner.nextLine().toLowerCase().startsWith("y");
		} while (proceed);
	}

	public void addPerson(Person person) {
		contacts.add(person);
	}

	public Person buildPerson(Person person, Scanner scanner) {
		System.out.println("\nPlease enter your friend's contact information.");

        while (person.getName() == null) {
            System.out.print("Full name: ");
            person.setName(validateName(scanner.nextLine()));
        }

        while (person.getBirthday() == null) {
            System.out.print("Birthday (" + dateFormat.toPattern() + "): ");
            person.setBirthday(validateDate(scanner.nextLine()));
        }

        while (person.getPhone() == null) {
            System.out.print("Phone number: ");
            person.setPhone(validatePhone(scanner.nextLine()));
        }

		while (person.getEmail() == null) {
            System.out.print("Email: ");
            person.setEmail(validateEmail(scanner.nextLine()));
        }

		return person;
	}

	public String validateName(String name) {
		if (name.matches("[A-Z][a-z]+(\\s[A-Z]\\.)*\\s[A-Z][a-z]+"))
			return name;
		else
			return null;
	}

	public Date validateDate(String string) {
		try {
			return dateFormat.parse(string);
		} catch (ParseException e) {
			return null;
		}
	}

	public String validatePhone(String phone) {
		if (phone.matches("\\+?\\d{5,}"))
			return phone;
		else
			return null;
	}

	public String validateEmail(String email) {
		if (email.matches("\\w+(\\.\\w+)*@\\w+(\\.\\w+)*\\.[A-Za-z]{2,}"))
			return email;
		else
			return null;
	}
}
