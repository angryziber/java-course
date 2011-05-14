/**
 * 
 */
package net.azib.java.students.t092861.homework;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Used to process the user requests and input data from files
 * 
 * @author Stanislav / 092861
 * 
 */
public class ControllerInput {

	private static final SimpleDateFormat DATE_FORMAT = (SimpleDateFormat) DateFormat
			.getDateInstance(DateFormat.SHORT);
	private static PrintStream out = System.out;
	private static Controller ctrl;


	public static enum Field {
		NAME {
			@Override
			public boolean parseAndStore(String line, Athlete athlete) {
				if (!ctrl.checkName(line)) {
					out
							.println(line
									+ "\nNames and surnames must start with capital letter.\n"
									+ "Charecters ' and - are allowed.\n"
									+ "Please check Firstname and Surname.\n");
					return true;
				} else {
					line = ctrl.removeQuotes(line);
					athlete.setName(line);
				}
				return false;
			}
		},
		BIRTHDAY {
			@Override
			public boolean parseAndStore(String line, Athlete athlete) {
				try {
					athlete.setBirthday(DATE_FORMAT.parse(line));
				} catch (ParseException e) {
					out.println(line + "\nFormat " + DATE_FORMAT.toPattern()
							+ " is allowed.\n" + "Please check Birthday.\n");
					return true;
				}
				return false;
			}
		},
		COUNTRY {
			@Override
			public boolean parseAndStore(String line, Athlete athlete) {
				if (!ctrl.checkCountry(line)) {
					out.println(line + "\nFormat XX is allowed.\n"
							+ "Please check country code.\n");
					return true;
				} else {
					athlete.setCountry(line);
				}
				return false;
			}
		},

		SPRINT_100 {
			@Override
			public boolean parseAndStore(String line, Athlete athlete) {
				if (ctrl.checkTime(line) == -1) {
					out.println(line + "\nFormat (sec) is allowed.\n"
							+ "Please check 100 m sprint results.\n");
					return true;
				} else {
					float time = ctrl.checkTime(line);
					athlete.setSprint100(time);
				}
				return false;
			}
		},

		LONG_JUMP {
			@Override
			public boolean parseAndStore(String line, Athlete athlete) {
				if (!ctrl.checkMeters(line)) {
					out.println(line + "\nFormat (m) is allowed.\n"
							+ "Please check Long jump results.\n");
					return true;
				} else {
					athlete
							.setLongJump(Float.valueOf(line.trim())
									.floatValue());
				}
				return false;
			}
		},

		SHOT_PUT {
			@Override
			public boolean parseAndStore(String line, Athlete athlete) {
				if (!ctrl.checkMeters(line)) {
					out.println(line + "\nFormat (m) is allowed.\n"
							+ "Please check Shot put results.\n");
					return true;
				} else {
					athlete
							.setShortPut(Float.valueOf(line.trim())
									.floatValue());
				}
				return false;
			}
		},

		HIGH_JUMP {
			@Override
			public boolean parseAndStore(String line, Athlete athlete) {
				if (!ctrl.checkMeters(line)) {
					out.println(line + "\nFormat (m) is allowed.\n"
							+ "Please check High jump results.\n");
					return true;
				} else {
					athlete
							.setHighJump(Float.valueOf(line.trim())
									.floatValue());
				}
				return false;
			}
		},

		SPRINT_400 {
			@Override
			public boolean parseAndStore(String line, Athlete athlete) {
				if (ctrl.checkTime(line) == -1) {
					out.println(line + "\nFormat (min:sec) is allowed.\n"
							+ "Please check 400 m sprint results.\n");
					return true;
				} else {
					float time = ctrl.checkTime(line);
					athlete.setSprint400(time);
				}
				return false;
			}
		},

		HURDLES {
			@Override
			public boolean parseAndStore(String line, Athlete athlete) {
				if (ctrl.checkTime(line) == -1) {
					out.println(line + "\nFormat (sec) is allowed.\n"
							+ "Please check 110 m hurdles results.\n");
					return true;
				} else {
					float time = ctrl.checkTime(line);
					athlete.setHurdles(time);
				}
				return false;
			}
		},

		DISCUS_THROW {
			@Override
			public boolean parseAndStore(String line, Athlete athlete) {
				if (!ctrl.checkMeters(line)) {
					out.println(line + "\nFormat (m) is allowed.\n"
							+ "Please check Discus throw results.\n");
					return true;
				} else {
					athlete.setDiscusThrow(Float.valueOf(line.trim())
							.floatValue());
				}
				return false;
			}
		},

		POLE_VAULT {
			@Override
			public boolean parseAndStore(String line, Athlete athlete) {
				if (!ctrl.checkMeters(line)) {
					out.println(line + "\nFormat (m) is allowed.\n"
							+ "Please check Pole vault results.\n");
					return true;
				} else {
					athlete.setPoleVault(Float.valueOf(line.trim())
							.floatValue());
				}
				return false;
			}
		},

		JAVELIN_THROW {
			@Override
			public boolean parseAndStore(String line, Athlete athlete) {
				if (!ctrl.checkMeters(line)) {
					out.println(line + "\nFormat (m) is allowed.\n"
							+ "Please check Javelin throw results.\n");
					return true;
				} else {
					athlete.setJavelinThrow(Float.valueOf(line.trim())
							.floatValue());
				}
				return false;
			}
		},

		RACE1500 {
			@Override
			public boolean parseAndStore(String line, Athlete athlete) {
				if (ctrl.checkTime(line) == -1) {
					out.println(line + "\nFormat (min:sec)  is allowed.\n"
							+ "Please check 1500 m race results.\n");
					return true;
				} else {
					float time = ctrl.checkTime(line);
					athlete.setSprint1500(time);
				}
				return false;
			}
		};

		public abstract boolean parseAndStore(String line, Athlete friend);
	}

	public static void setController(Controller ctrl) {
		ControllerInput.ctrl = ctrl;
	}

}
