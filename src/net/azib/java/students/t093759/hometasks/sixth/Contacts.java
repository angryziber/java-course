package net.azib.java.students.t093759.hometasks.sixth;

import java.util.*;

/**
 * 30.03.11 21:45
 *
 * @author dionis
 */
public class Contacts {
	private List<ContactInformation> contactInformations = new ArrayList<ContactInformation>();

	public void add(ContactInformation contactInformation) {
		contactInformations.add(contactInformation);
	}

	public Collection<ContactInformation> getContacts() {
		return Collections.unmodifiableCollection(contactInformations);
	}

	@Override
	public String toString() {
		StringBuilder compoundRepresentation = new StringBuilder("");
		for (ContactInformation contactInformation : getContacts()) {
			compoundRepresentation.append(contactInformation.toString() + "\n");
		}

		return compoundRepresentation.toString();
	}

	public static void main(String[] args) {
		Contacts myFriends = new Contacts();

		Scanner scanner = new Scanner(System.in);
		PersonName personName;
		PhoneNumber phoneNumber;
		Email email;
		Birthday birthday;


		System.out.println("Please enter your friends names:");
		System.out.println("NB! All fields are required.");

		do {
			personName = scanPersonName(scanner);
			phoneNumber = scanPhoneNumber(scanner);
			email = scanEmail(scanner);
			birthday = scanBirthday(scanner);
			myFriends.add(new ContactInformation(personName, phoneNumber, email, birthday));
			System.out.println("Current Friends:");
			System.out.println(myFriends);
			//Bug with exiting from loop
		} while (scanner.hasNext());

		System.out.println(myFriends);

	}

	private static PersonName scanPersonName(Scanner scanner) {
		System.out.println("Enter person name");
		try {
			return new PersonName(scanner.nextLine());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return scanPersonName(scanner);
		}
	}

	private static PhoneNumber scanPhoneNumber(Scanner scanner) {
		System.out.println("Enter phone number");
		try {
			return new PhoneNumber(scanner.nextLine());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return scanPhoneNumber(scanner);
		}
	}

	private static Birthday scanBirthday(Scanner scanner) {
		System.out.println("Enter birthday in format " + Birthday.FORMAT);
		try {
			return new Birthday(scanner.nextLine());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return scanBirthday(scanner);
		}
	}

	private static Email scanEmail(Scanner scanner) {
		System.out.println("Enter email");
		try {
			return new Email(scanner.nextLine());
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return scanEmail(scanner);
		}
	}
}
