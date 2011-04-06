/**
 * 
 */
package net.azib.java.lessons.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copied from t092861 to serve as an example of refactoring (look at history)
 *
 * @author Stanislav / 092861
 */
public class Contacts {
	private static final SimpleDateFormat DATE_FORMAT = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
	private static PrintStream out = System.out;

	public static enum Field {
		NAME {
			@Override
			public boolean parseAndStore(String line, Friend friend) {
				if (!checkName(line)) {
					out.println("\nNames and surnames must start with capital letter.\n"
							+ "Charecters ' and - are allowed.\n"
							+ "Please enter new Firstname and Surname again.\n");
					return true;
				} else {
					friend.setName(line);
				}
				return false;
			}
		},
		BIRTHDAY {
			@Override
			public boolean parseAndStore(String line, Friend friend) {
				try {
					friend.setBirthday(DATE_FORMAT.parse(line));
				} catch (ParseException e) {
					out.println("\nFormat " + DATE_FORMAT.toPattern() + " is allowed.\n"
							+ "Please enter new Birthday.\n");
					return true;
				}
				return false;
			}
		},
		EMAIL {
			@Override
			public boolean parseAndStore(String line, Friend friend) {
				if (!checkMail(line)) {
					out
							.println("\nFormat name@hostname.domain is allowed.\n"
									+ "Please enter new email address.\n");
					return true;
				} else {
					friend.setEmail(line);
				}
				return false;
			}
		},
		PHONE {
			@Override
			public boolean parseAndStore(String line, Friend friend) {
				if (!checkNumber(line)) {
					out
							.println("\nOnly digits and (+xxx) country code is allowed.\n"
									+ "Please enter new phone number.\n");
					return true;
				} else {
					friend.setPhoneNmber(line);
				}
				return false;
			}
		},
		FACEBOOK {
			@Override
			public boolean parseAndStore(String line, Friend friend) {
				if (!checkFacebook(line)) {
					out
							.println("\nOnly digits and \".\" is allowed\n"
									+ "Please enter new facebook username(?).\n");
					return true;
				} else {
					friend.setFacebook(line);
				}
				return false;
			}
		};

		public abstract boolean parseAndStore(String line, Friend friend);
	}

	private Friend newFriend;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Contacts contacts = new Contacts();
		contacts.friendsDataInput();
	}

	public void friendsDataInput() throws IOException {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		int index = 1;
		out.println("Please enter you friend's data (enter 'stop' to quit): ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while (true) {
			newFriend = new Friend();
			for (int i = 0; i < Field.values().length; i++) {
				Field field = Field.values()[i];
				out.print((index) + ": " + field.name() + ": ");
				line = reader.readLine();

				boolean invalidInput = field.parseAndStore(line, newFriend);
				if (invalidInput)
					i--;
			}

			friends.add(newFriend);
			out.print("\nWould you like to add another friend (y/n)?");
			line = reader.readLine();
			if (line.equalsIgnoreCase("n")) {
				break;
			} else {
				out.println("");
				index++;
			}
		}
		printAllContacts(friends);
	}

	public static boolean checkName(String name) {
		String sFirstName = "^[A-Z]{1}[\\D\'-]*[\\p{Alnum}]+";
		String sSurName = "[A-Z]{1}[\\D\'-]*[\\p{Alnum}]+$";
		String sName = sFirstName + " " + sSurName;
		return matchThePattern(sName, name);
	}

	public static boolean checkMail(String mail) {
		String sName = "^(?!www\\.).*(?!WWW\\.).*[_A-Za-z0-9\\.-]+";
		String sDomain = "[\\w\\.-]+(\\.[A-Za-z0-9]+)*"; // plus optional sub
															// domain group
		String sHost = "[A-Za-z]{2,4}$";
		String sEmail = sName + "@" + sDomain + "\\." + sHost;
		return matchThePattern(sEmail, mail);
	}

	public static boolean checkNumber(String phone) {
		String sNumber = "^\\(?\\+?(\\d)+\\)?[- ]?(\\d)+[- ]?(\\d)+$";
		return matchThePattern(sNumber, phone);
	}

	public static boolean checkFacebook(String facebook) {
		String sFacebook = "^[A-Za-z0-9\\.]{5,}$";
		return matchThePattern(sFacebook, facebook);
	}

	public static boolean matchThePattern(String patt, String str) {
		Pattern pattern = Pattern.compile(patt);
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public void printAllContacts(ArrayList<Friend> friends) {

		out.println("\nHere are the results:");
		out.printf(" %-21s|%11s |%20s |%17s |%17s\n", Field.NAME,
				Field.BIRTHDAY, Field.EMAIL, Field.PHONE, Field.FACEBOOK);
		for (Friend friend : friends) {
			out.printf(" %-21s|%11s |%20s |%17s |%17s\n", friend
					.getName(), DATE_FORMAT
					.format(friend.getBirthday()), friend.getEmail(), friend
					.getPhoneNmber(), friend.getFacebook());

		}
	}
}
