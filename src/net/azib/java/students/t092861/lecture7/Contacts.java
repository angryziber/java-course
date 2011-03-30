/**
 * 
 */
package net.azib.java.students.t092861.lecture7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Stanislav / 092861
 * 
 */
public class Contacts {
	public static final String[] INPUTDATA = new String[] { "Friends's name: ",
			"Birthday: ", "E-mail: ", "Phone number: ", "Facebook: " };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Contacts contacts = new Contacts();
		try {
			contacts.frindsDataInput();
		} catch (IOException e) {
			System.out
					.println("Error! I/O exception of some sort has occurred");
			e.printStackTrace();
		}
	}

	public void frindsDataInput() throws IOException {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		int index = 1;
		int count = 0;
		boolean next = true;
		System.out
				.println("Please enter you friend's data (enter 'stop' to quit): ");
		InputStreamReader isReader = new InputStreamReader(System.in, "UTF8");
		BufferedReader bReader = new BufferedReader(isReader);
		String line;
		Friend newFriend;
		while (next) {
			newFriend = new Friend();
			do {
				System.out.print((index) + ": " + INPUTDATA[count]);
				line = bReader.readLine();

				// inputting the name
				if (INPUTDATA[count].contains("name")) {
					if (!checkName(line)) {
						System.out
								.println("\nNames and surnames must start with capital letter.\n"
										+ "Charecters ' and - are allowed.\n"
										+ "Please enter new Firstname and Surname again.\n");
						continue;
					} else {
						newFriend.setName(line);
					}
				}
				// inputting the Birthday
				if (INPUTDATA[count].contains("Birthday")) {
					if (!checkDate(line)) {
						System.out.println("\nFormat dd.mm.yyyy is allowed.\n"
								+ "Please enter new Birthday.\n");
						continue;
					} else {
						newFriend.setBirthday(line);
					}
				}
				// inputting the mail
				if (INPUTDATA[count].contains("mail")) {
					if (!checkMail(line)) {
						System.out
								.println("\nFormat name@hostname.domain is allowed.\n"
										+ "Please enter new email address.\n");
						continue;
					} else {
						newFriend.setEmail(line);
					}
				}
				// inputting the phone number
				if (INPUTDATA[count].contains("number")) {
					if (!checkNumber(line)) {
						System.out
								.println("\nOnly digits and (+xxx) country code is allowed.\n"
										+ "Please enter new phone number.\n");
						continue;
					} else {
						newFriend.setPhoneNmber(line);
					}
				}
				// inputting the Facebook
				if (INPUTDATA[count].contains("Facebook")) {
					if (!checkFacebook(line)) {
						System.out
								.println("\nOnly digits and \".\" is allowed\n"
										+ "Please enter new phone number.\n");
						continue;
					} else {
						newFriend.setFacebook(line);
					}
				}
				count++;
			} while (count != INPUTDATA.length);

			friends.add(newFriend);
			System.out.print("\nWould you like to add another friend (y/n)?");
			line = bReader.readLine();
			if (line.equals("n")) {
				next = false;
			} else {
				System.out.println("");
				count = 0;
				index++;
			}
		}
		printAllContacts(friends);
	}

	public boolean checkName(String name) {
		String sFirstName = "^[A-Z]{1}[\\D\'-]*[\\p{Alnum}]+";
		String sSurName = "[A-Z]{1}[\\D\'-]*[\\p{Alnum}]+$";
		String sName = sFirstName + " " + sSurName;
		return matchThePattern(sName, name);
	}

	public boolean checkDate(String date) {
		String day = "^\\d{1,2}";
		String month = "\\d{1,2}";
		String year = "\\d{2,4}$";
		String sDate = day + "\\." + month + "\\." + year;
		return matchThePattern(sDate, date);
	}

	public boolean checkMail(String mail) {
		String sName = "^(?!www\\.).*(?!WWW\\.).*[_A-Za-z0-9\\.-]+";
		String sDomain = "[\\w\\.-]+(\\.[A-Za-z0-9]+)*"; // plus optional sub
															// domain group
		String sHost = "[A-Za-z]{2,4}$";
		String sEmail = sName + "@" + sDomain + "\\." + sHost;
		return matchThePattern(sEmail, mail);
	}

	public boolean checkNumber(String phone) {
		String sNumber = "^\\(?\\+?(\\d)+\\)?[- ]?(\\d)+[- ]?(\\d)+$";
		return matchThePattern(sNumber, phone);
	}

	public boolean checkFacebook(String facebook) {
		String sFacebook = "^[A-Za-z0-9\\.]{5,}$";
		return matchThePattern(sFacebook, facebook);
	}

	public boolean matchThePattern(String patt, String str) {
		Pattern pattern = Pattern.compile(patt);
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public void printAllContacts(ArrayList<Friend> friends) {

		System.out.println("\nHere are the results:");
		System.out.printf(" %-21s|%11s |%20s |%17s |%17s\n", "Name",
				"Birthday", "Email", "Tel.", "Facebook\n");
		for (Friend friend : friends) {
			System.out.printf(" %-21s|%11s |%20s |%17s |%17s\n", friend
					.getName(), new SimpleDateFormat("dd.MM.yyyy")
					.format(friend.getBirthday()), friend.getEmail(), friend
					.getPhoneNmber(), friend.getFacebook());

		}
	}
}
