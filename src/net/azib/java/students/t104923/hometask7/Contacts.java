package net.azib.java.students.t104923.hometask7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {

	private List<SomePerson> contactsList = new ArrayList<SomePerson>();
	private Scanner scanner = resetScanner();

	private Scanner resetScanner() {
		return scanner = new Scanner(System.in).useDelimiter("\n");
	}

	public static void main(String[] args) {
		Contacts contacts = new Contacts();
		System.out.println("Hello, do you want to add a contact? (y/n)");
		String yesOrNo = contacts.scanner.next();
		if (yesOrNo.equals("y")) {
			contacts.contactsList.add(contacts.createContact());
		}
		else if (yesOrNo.equals("n")) {

		}
		else if (!yesOrNo.equals("y") & !yesOrNo.equals("n")) {
			System.out.println("Input error! (\"y\" or \"n\" only)");
		}
		System.out.println(contacts.contactsList);

	}

	private SomePerson createContact() {
		SomePerson person = new SomePerson();
		String contactName = "";
		do {
			try {
				System.out.println("Contact's Name:");
				contactName = scanner.next("[A-Z][a-z]*\\s[A-Z][a-z]*");
				person.setName(contactName);
    	    } catch (Exception e){
				System.out.println("Input Name Error (example: James Brown) " + e);
				resetScanner();
			}
		} while (contactName.equals(""));

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
