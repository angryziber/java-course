/**
 * 
 */
package net.azib.java.students.t092861.homework;

import java.io.PrintStream;
import java.text.ParseException;

/**
 * Used to process the user requests and input data from files.
 * 
 * @author Stanislav / 092861
 * 
 */
public class ControllerInput {

	/**
	* System.out local variable. 
	*/
	private static PrintStream out = System.out;
	
	/**
	 * Controller instance.
	 */
	private static Controller ctrl;

	/**
	 * @author Stanislav / 092861
	 *
	 */
	public static enum Field {
		NAME {
			@Override
			public boolean parseAndStore(String value, Athlete athlete) {
				if (!ctrl.checkName(value)) {
					out
							.println(value
									+ "\nNames and surnames must start with capital letter.\n"
									+ "Charecters ' and - are allowed.\n"
									+ "Please check Firstname and Surname.\n");
					return true;
				} else {
					value = ctrl.removeQuotes(value);
					athlete.setName(value);
				}
				return false;
			}
		},
		BIRTHDAY {
			@Override
			public boolean parseAndStore(String value, Athlete athlete) {
				try {
					athlete.setBirthday(Const.DATE_FORMAT.parse(value));
				} catch (ParseException e) {
					out.println(value + "\nFormat " + Const.DATE_FORMAT.toPattern()
							+ " is allowed.\n" + "Please check Birthday.\n");
					return true;
				}
				return false;
			}
		},
		COUNTRY {
			@Override
			public boolean parseAndStore(String value, Athlete athlete) {
				if (!ctrl.checkCountry(value)) {
					out.println(value + "\nFormat XX is allowed.\n"
							+ "Please check country code.\n");
					return true;
				} else {
					athlete.setCountry(value);
				}
				return false;
			}
		},

		SPRINT_100 {
			@Override
			public boolean parseAndStore(String value, Athlete athlete) {
				if (ctrl.checkTime(value) == -1) {
					out.println(value + "\nFormat (sec) is allowed.\n"
							+ "Please check 100 m sprint results.\n");
					return true;
				} else {
					float time = ctrl.checkTime(value);
					athlete.setSprint100(time);
				}
				return false;
			}
		},

		LONG_JUMP {
			@Override
			public boolean parseAndStore(String value, Athlete athlete) {
				if (!ctrl.checkMeters(value)) {
					out.println(value + "\nFormat (m) is allowed.\n"
							+ "Please check Long jump results.\n");
					return true;
				} else {
					athlete
							.setLongJump(Float.valueOf(value.trim())
									.floatValue());
				}
				return false;
			}
		},

		SHOT_PUT {
			@Override
			public boolean parseAndStore(String value, Athlete athlete) {
				if (!ctrl.checkMeters(value)) {
					out.println(value + "\nFormat (m) is allowed.\n"
							+ "Please check Shot put results.\n");
					return true;
				} else {
					athlete
							.setShortPut(Float.valueOf(value.trim())
									.floatValue());
				}
				return false;
			}
		},

		HIGH_JUMP {
			@Override
			public boolean parseAndStore(String value, Athlete athlete) {
				if (!ctrl.checkMeters(value)) {
					out.println(value + "\nFormat (m) is allowed.\n"
							+ "Please check High jump results.\n");
					return true;
				} else {
					athlete
							.setHighJump(Float.valueOf(value.trim())
									.floatValue());
				}
				return false;
			}
		},

		SPRINT_400 {
			@Override
			public boolean parseAndStore(String value, Athlete athlete) {
				if (ctrl.checkTime(value) == -1) {
					out.println(value + "\nFormat (min:sec) is allowed.\n"
							+ "Please check 400 m sprint results.\n");
					return true;
				} else {
					float time = ctrl.checkTime(value);
					athlete.setSprint400(time);
				}
				return false;
			}
		},

		HURDLES {
			@Override
			public boolean parseAndStore(String value, Athlete athlete) {
				if (ctrl.checkTime(value) == -1) {
					out.println(value + "\nFormat (sec) is allowed.\n"
							+ "Please check 110 m hurdles results.\n");
					return true;
				} else {
					float time = ctrl.checkTime(value);
					athlete.setHurdles(time);
				}
				return false;
			}
		},

		DISCUS_THROW {
			@Override
			public boolean parseAndStore(String value, Athlete athlete) {
				if (!ctrl.checkMeters(value)) {
					out.println(value + "\nFormat (m) is allowed.\n"
							+ "Please check Discus throw results.\n");
					return true;
				} else {
					athlete.setDiscusThrow(Float.valueOf(value.trim())
							.floatValue());
				}
				return false;
			}
		},

		POLE_VAULT {
			@Override
			public boolean parseAndStore(String value, Athlete athlete) {
				if (!ctrl.checkMeters(value)) {
					out.println(value + "\nFormat (m) is allowed.\n"
							+ "Please check Pole vault results.\n");
					return true;
				} else {
					athlete.setPoleVault(Float.valueOf(value.trim())
							.floatValue());
				}
				return false;
			}
		},

		JAVELIN_THROW {
			@Override
			public boolean parseAndStore(String value, Athlete athlete) {
				if (!ctrl.checkMeters(value)) {
					out.println(value + "\nFormat (m) is allowed.\n"
							+ "Please check Javelin throw results.\n");
					return true;
				} else {
					athlete.setJavelinThrow(Float.valueOf(value.trim())
							.floatValue());
				}
				return false;
			}
		},

		RACE1500 {
			@Override
			public boolean parseAndStore(String value, Athlete athlete) {
				if (ctrl.checkTime(value) == -1) {
					out.println(value + "\nFormat (min:sec)  is allowed.\n"
							+ "Please check 1500 m race results.\n");
					return true;
				} else {
					float time = ctrl.checkTime(value);
					athlete.setSprint1500(time);
				}
				return false;
			}
		};

		/**
		 * Parses the value from file or console and stores in the model.
		 * @param value to be checked and stored
		 * @param athlete 
		 * @return true if validation was not passed 
		 */
		public abstract boolean parseAndStore(String value, Athlete athlete);
	}

	/**
	 * Sets controller instance.
	 * 
	 * @param ctrl
	 */
	public static void setController(Controller ctrl) {
		ControllerInput.ctrl = ctrl;
	}

}
