package net.azib.java.students.t073857.hw5;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Contacts
 *
 * @author Joonas Vali
 * I ran out of time, may be a bit buggy.
 */
public class Contacts {
	public static void main(String[] args) throws ParseException {
		boolean insert = true;
		int counter = 1;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		Name name;
		Date birthday;
		Email email;
		long phone;
		
		ins: while(insert){
			name = null;
			birthday = null;
			email = null;
			phone = 0;
			while(name == null){
				try{
					System.out.println(counter+") Enter name(empty to exit):");
					name = new Name(scanner.nextLine());
				} catch(IllegalArgumentException e){
					System.out.println("Cancelled..");
					insert = false;
					break ins;
				}
			}
			while(birthday == null){
				try{
					System.out.println(counter+") Enter birthday("+Contact.format.toPattern()+"):");
					birthday =  Contact.format.parse(scanner.nextLine());
				} catch(ParseException e){
					System.out.println("Enter birthday in format shown below:");
				}
				
			}
			while(email == null){
				try{
					System.out.println(counter+") Enter email:");
					email =  new Email(scanner.nextLine());
				} catch(IllegalArgumentException e){ 
					System.out.println("Insert a correct Email.");
				}
			}
			while(phone == 0){
				try{
					System.out.println(counter+") Enter phone nr:");
					phone = Long.parseLong(scanner.nextLine());
				} catch(NumberFormatException e){ }
			}
			counter++;
			contacts.add(new Contact(name, birthday, email, phone));		
		}
		
		for(Contact c:contacts){
			System.out.println(c);
		}
		
	}
}

