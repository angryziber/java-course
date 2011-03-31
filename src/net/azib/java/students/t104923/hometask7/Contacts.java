package net.azib.java.students.t104923.hometask7;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {

	private static List<SomePerson> contacts = new ArrayList<SomePerson>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Hello, do you want to add a contact? (y/n)");
		String yesOrNo = scanner.next();
		if (yesOrNo.equals("y")) {
			//createContact();
			contacts.add(createContact());
		}
		else if (yesOrNo.equals("n")) {

		}
		else if (!yesOrNo.equals("y") & !yesOrNo.equals("n")) {
			System.out.println("Input error! (\"y\" or \"n\" only)");
		}

	}

	private static SomePerson createContact() {
		SomePerson person = new SomePerson();
		scanner.useDelimiter("\n");

		System.out.println("Contact's Name:");
		String contactName = scanner.next("[A-Z][a-z]+\\s[A-Z][a-z]+");

		person.setName(contactName);
		System.out.println("Contact's Birthday (dd.mm.yyyy) :");
		String contactBirthday = scanner.next("[0-3]?[0-9]{1}\\.[0-1]{1}[0-9]{1}\\.[1,2]{1}[0,9]{1}[0-9]{2}$");

		person.setBirthDay(contactBirthday);
		System.out.println("Contact's Phone Number:");
		String contactNumber = scanner.next("[+\\d]+");

		person.setPhoneNumber(contactNumber);
		System.out.println("Contact's E-mail:");
		String contactEmail = scanner.next(".+@.+\\..+");

		person.setEmail(contactEmail);
		System.out.println("Do you want to add another contact? (y/n)");
		return person;
	}
}
