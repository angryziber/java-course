package net.azib.java.students.t073639.taskContacts;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Contacts
 * 
 * @author t073639
 */
public class Contacts {
	String name;
	String birthday;
	String email;
	String phoneNumber;

	Pattern namePattern = Pattern.compile("[A-Z]{1}[a-z]+\\ [A-Z]{1}[a-z]+");
	Pattern emailPattern = Pattern.compile("[a-z0-9_A-Z.]+@[-a-zA-Z0-9.]+\\.[a-zA-Z]{2,4}");
	Pattern birthdayPattern = Pattern.compile("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}");
	Pattern phoneNumPattern = Pattern.compile("[0-9]+");

	public Contacts() {
		Locale.setDefault(new Locale("et"));
		this.fillContacts();
	}

	public Contacts(String name, String birthday, String email, String phoneNumber) {
		Locale.setDefault(new Locale("et"));
		SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
		this.name = name;
		try {
			this.birthday = dateFormat.format(dateFormat.parse(birthday));
		}
		catch (ParseException e) {
			this.birthday = "01.01.1970";
		}
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	private void fillContacts() {
		SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
		this.name = fillCheckedDate("Enter name", name, namePattern);
		try {
			this.birthday = dateFormat.format(dateFormat.parse(fillCheckedDate("Enter birthday", birthday, birthdayPattern)));
		}
		catch (ParseException e) {
			this.birthday = "01.01.1988";
		}
		this.email = fillCheckedDate("Enter email", email, emailPattern);
		this.email = fillCheckedDate("Enter phone number", phoneNumber, phoneNumPattern);

	}

	private String fillCheckedDate(String print, String val, Pattern p) {
		Scanner s = new Scanner(System.in).useDelimiter("\n");
		boolean b = false;
		while (b != true) {
			System.out.println(print);
			val = s.next();
			if (Pattern.matches(p.toString(), val)) {
				b = true;
				System.out.println(val + ".....Ok");
			}
			else {
				b = false;
				System.out.println("Error! Please try again.");
			}
		}
		return val;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getBirthday() {

		return birthday;
	}

	public String getPhoneNum() {
		return phoneNumber;
	}

}
