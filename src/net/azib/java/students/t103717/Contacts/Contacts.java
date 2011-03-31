package net.azib.java.students.t103717.Contacts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Vector;

/**
 * User: ruzard
 * Malyshev Konstantin 103717IAPB28
 * Date: 30.03.11
 * TODO tests
 */
public class Contacts {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		String string;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Vector<Member> vector = new Vector<Member>();
		boolean addNext = true;

//		0Name and Surname
//		1Phone
//		2Birthday
//		3email
//		4favourite fruit
//		5Girlfriend's name
//		6Girlfriend's weight


		//I have commented out many strings because it was impossible to answer all questions :)
		while (addNext) {
			Member newMember = new Member();
			System.out.println("Your name, what is.");
			string = scanner.next("[A-Z][a-z]+\\s[A-Z][a-z]+");
			newMember.name = string;

//		System.out.println("Your phone number, give me... yess");
//		string = scanner.next("[']+\\d{3}+\\s+\\d{6,9}");
//		newMember.phone = string;
//
//		System.out.println("When you born were.  Herh herh herh. dd.MM.yyyy");
//		string = scanner.next();
//			try {
//				newMember.birthday = df.parse(string);
//			} catch (ParseException e) {
//				e.printStackTrace();  }

//
			System.out.println("Email your, tell me... yess..");
			string = scanner.next("[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			newMember.email = string;
//
//		System.out.println("Favorite fruit, you have, hmm?");
//		string = scanner.next("*[A-Za-z]");
//		newMember.fruit = string;
//
//		System.out.println("Name of your girlfriend, what is, hmm?");
//		string = scanner.next("[A-Z][a-z]*\\s[A-Z][a-z]+");
//		newMember.gname = string;
//
//		System.out.println("Your girlfriend weights how many kilos.  Yes, hmmm.");
//		string = scanner.next("[0-9]");
//		newMember.gweight = Integer.parseInt(string);

			System.out.println("Do you want to add one more contact? y/n");
			string = scanner.next();
			vector.addElement(newMember);
			if ((string.contains("y")) || (string.contains("Y"))) {
			} else {
				addNext = false;
			}

		}//while ends


		int counter = 0;
		for (Member printableMember : vector) {
			printableMember = vector.elementAt(counter);
			printMember(printableMember);
			counter++;
		}


	}

	public static void printMember(Member member) {
		StringBuilder sb = new StringBuilder("Contact's name is ");
		sb.append(member.name).append("\nemail: ").append(member.email).append("\n\n");
		System.out.println(sb.toString());

		//.append(".\nPhone Number: ").append(member.phone).append("\nBirthday: ").append(member.birthday.toString());


	}
}