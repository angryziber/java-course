package net.azib.java.students.t104607;
// @author 104607 IASM

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class Contacts {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");

		Contact contact = new Contact();
		while (contact.getName() == null) {
			System.out.println("Enter name in format 'Firstname Lastname'");
			contact.setName(scanner.next());
		}
		while (contact.getBirthday() == null) {
			System.out.println("Enter birthday, for example today - " + DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()));
			contact.setBirthday(scanner.next());
		}
		while (contact.getEmail() == null) {
			System.out.println("Enter e-mail in format 'name@domain.org'");
			contact.setEmail(scanner.next());
		}
		while (contact.getPhone() == null) {
			System.out.println("Enter phone number in format '372-555-5555'");
			contact.setPhone(scanner.next());
		}
		System.out.println("Contact information:");
		System.out.println("\tName:\t\t" + contact.getName());
		System.out.println("\tBirthday:\t" + contact.getBirthday());
		System.out.println("\tE-mail:\t\t" + contact.getEmail());
		System.out.println("\tPhone:\t\t" + contact.getPhone());
	}
}
