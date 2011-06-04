package net.azib.java.students.t103784.homework;


import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * This class is used to input the athletes and their results.
 *
 * @author Ott Madis Ozolit <karuott321@hotmail.com>
 * @version 1.6
 * @since 2011.0520
 */
public class Input {

	String parameter = Main.inputParameter;
	List<Athlete> contestants = new ArrayList<Athlete>();

	/**
	 * Reads in athletes from a database.
	 * <p/>
	 * Opens a connection to a database, executes an SQL query
	 * which returns the required combined table to fill
	 * a list of athletes with their data.
	 * Also calculates each athlete's score once one is read in.
	 *
	 * @return Returns the list of athletes that is read in from the database.
	 * @throws java.sql.SQLException    Is thrown when a SQL statement is invalid.
	 * @throws java.text.ParseException Is thrown when a parse error occurs.
	 * @throws java.io.IOException      Is thrown when there is something wrong with the properties file (e.g. not found).
	 */
	public List<Athlete> readAthleteFromDB() throws SQLException, ParseException, IOException {
		int i = 0;
		BufferedReader reader = new BufferedReader(new FileReader("src/net/azib/java/students/t103784/homework/db.properties"));
		String connAddress = reader.readLine();
		String connUserPass = reader.readLine();
		Connection conn = DriverManager.getConnection(connAddress, connUserPass, connUserPass);
		conn.setAutoCommit(false);
		try {
			Statement statement = conn.createStatement();
			ResultSet rs;
			if (parameter == null) {
				parameter = String.valueOf(1);
				rs = statement.executeQuery(
						"SELECT a. * , r. * \n" +
								"FROM athletes a, results r\n" +
								"WHERE a.id = r.athlete_id\n" +
								"AND r.competition_id =" + parameter + "\n" +
								"ORDER BY a.id ASC"
				);

			} else if (parameter.matches("\\d+")) {
				rs = statement.executeQuery(
						"SELECT a. * , r. * \n" +
								"FROM athletes a, results r\n" +
								"WHERE a.id = r.athlete_id\n" +
								"AND r.competition_id =" + parameter + "\n" +
								"ORDER BY a.id ASC"
				);
			} else {
				rs = statement.executeQuery(
						"SELECT a. * , r. * , c. *\n" +
								"FROM competitions c, athletes a, results r\n" +
								"WHERE a.id = r.athlete_id\n" +
								"AND c.name =" + "'" + parameter + "'" + "\n" +
								"AND c.id = r.competition_id\n" +
								"ORDER BY a.id ASC"
				);
			}

			while (!rs.isLast()) {
				if (!rs.next()) {
					return null;
				}
				Athlete athlete = new Athlete();
				athlete.setName(rs.getString("name"));
				athlete.setBirthDate(rs.getString("dob"));
				athlete.setCountry(rs.getString("country_code"));
				athlete.setPerformance(i, rs.getDouble("race_100m"));
				i++;
				athlete.setPerformance(i, rs.getDouble("long_jump"));
				i++;
				athlete.setPerformance(i, rs.getDouble("shot_put"));
				i++;
				athlete.setPerformance(i, rs.getDouble("high_jump"));
				i++;
				athlete.setPerformance(i, rs.getDouble("race_400m"));
				i++;
				athlete.setPerformance(i, rs.getDouble("hurdles_110m"));
				i++;
				athlete.setPerformance(i, rs.getDouble("discus_throw"));
				i++;
				athlete.setPerformance(i, rs.getDouble("pole_vault"));
				i++;
				athlete.setPerformance(i, rs.getDouble("javelin_throw"));
				i++;
				athlete.setPerformance(i, rs.getDouble("race_1500m"));
				i = 0;
				ScoreCalculator.calculate(athlete);
				contestants.add(athlete);
			}
		} catch (SQLException e) {
			conn.rollback();
			System.out.println(("Failed to load athletes"));
		} finally {
			conn.close();
		}

		return contestants;
	}

	/**
	 * Reads in athletes from a .csv file.
	 * <p/>
	 * The method is given a parameter (a reader) which also holds the
	 * input file and its path. The file is processed with a tokenizer,
	 * which separates entries using comma as a delimiter to properly assign values
	 * to the athlete. During the reading, information is also validated to prevent
	 * mistakes. The reading continues till there are no more lines left in the
	 * file. After that, the list of athletes is returned.
	 * Also calculates each athlete's score once one is read in.
	 *
	 * @param reader A buffered reader which is reading in data from a pre-set or default .csv file.
	 * @return Returns the list of athletes that is read in from the .csv file.
	 */
	public List<Athlete> readAthleteFromCSV(BufferedReader reader) {
		try {
			String line;
			StringTokenizer tokenizer;

			while ((line = reader.readLine()) != null) {
				Athlete athlete = new Athlete();
				tokenizer = new StringTokenizer(line.trim(), ",");
				while (tokenizer.hasMoreTokens()) {
					athlete.setName(checkName(tokenizer.nextToken().trim()));
					athlete.setBirthDate(tokenizer.nextToken().trim());
					athlete.setCountry(checkCountry(tokenizer.nextToken().trim()));
					for (int c = 0; c < 10; c++) {
						if (c == 4 || c == 9) {
							athlete.setPerformance(c, checkMinSec(tokenizer.nextToken().trim()));
						} else {
							athlete.setPerformance(c, checkIsNumber(String.valueOf(Double.parseDouble(tokenizer.nextToken().trim()))));
						}
					}
					ScoreCalculator.calculate(athlete);
					contestants.add(athlete);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}
		return contestants;
	}

	/**
	 * Reads in athletes from the console.
	 * <p/>
	 * The user must enter athlete data as required, the input will be validated
	 * and information will be asked until the user gets the input right.
	 * When the user finishes entering an athlete he/she can choose to enter
	 * more or stop entering, after which a list filled with athletes is returned.
	 * Also calculates each athlete's score once one is read in.
	 *
	 * @return Returns the list of athletes that is read in from console.
	 * @throws java.io.IOException      Is thrown when a reading error occurs.
	 * @throws java.text.ParseException Is thrown when a parse error occurs.
	 */
	public List<Athlete> readAthleteFromConsole() throws IOException, ParseException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		Locale.setDefault(new Locale("et"));
		SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
		int i = 0;
		boolean inputtingAthletes = true;

		while (inputtingAthletes) {
			Athlete athlete = new Athlete();

			while (athlete.getName() == null) {
				System.out.print("Full name (Name Surname): ");
				athlete.setName(checkName(reader.readLine()));
			}

			while (athlete.getBirthDate() == null) {
				System.out.print("Date of Birth " + "(" + format.toPattern() + "): ");
				String checkDateResult = checkDate(reader.readLine());
				if (checkDateResult == null) {
					System.out.println("Error in input. Try again.");
				} else {
					athlete.setBirthDate(checkDateResult);
				}
			}

			while (athlete.getCountry() == null) {
				System.out.print("Country (2-digits, eg. EE): ");
				athlete.setCountry(checkCountry(reader.readLine()));
			}

			while (athlete.getPerformance(i) == 0.0) {
				System.out.print("100m (seconds.milliseconds): ");
				try {
					athlete.setPerformance(i, checkIsNumber(reader.readLine()));
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
			}
			i++;

			while (athlete.getPerformance(i) == 0.0) {
				System.out.print("Long jump (meters.centimeters): ");
				try {
					athlete.setPerformance(i, checkIsNumber(reader.readLine()));
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
			}
			i++;

			while (athlete.getPerformance(i) == 0.0) {
				System.out.print("Shot put (meters.centimeters): ");
				try {
					athlete.setPerformance(i, checkIsNumber(reader.readLine()));
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
			}
			i++;

			while (athlete.getPerformance(i) == 0.0) {
				System.out.print("High jump (meters.centimeters): ");
				try {
					athlete.setPerformance(i, checkIsNumber(reader.readLine()));
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
			}
			i++;

			while (athlete.getPerformance(i) == 0.0) {
				System.out.print("400m (minutes:seconds.milliseconds): ");
				try {
					athlete.setPerformance(i, checkMinSec(reader.readLine()));
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
			}
			i++;

			while (athlete.getPerformance(i) == 0.0) {
				System.out.print("110m hurdles (seconds.milliseconds): ");
				try {
					athlete.setPerformance(i, checkIsNumber(reader.readLine()));
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
			}
			i++;

			while (athlete.getPerformance(i) == 0.0) {
				System.out.print("Discus throw (meters.centimeters): ");
				try {
					athlete.setPerformance(i, checkIsNumber(reader.readLine()));
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
			}
			i++;

			while (athlete.getPerformance(i) == 0.0) {
				System.out.print("Pole vault (meters.centimeters): ");
				try {
					athlete.setPerformance(i, checkIsNumber(reader.readLine()));
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
			}
			i++;

			while (athlete.getPerformance(i) == 0.0) {
				System.out.print("Javelin throw (meters.centimeters): ");
				try {
					athlete.setPerformance(i, checkIsNumber(reader.readLine()));
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
			}
			i++;

			while (athlete.getPerformance(i) == 0.0) {
				System.out.print("1500m race (minutes:seconds.milliseconds): ");
				try {
					athlete.setPerformance(i, checkMinSec(reader.readLine()));
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
			}
			i = 0;
			ScoreCalculator.calculate(athlete);
			contestants.add(athlete);
			System.out.print("Add more athletes (y/n)? ");
			inputtingAthletes = reader.readLine().toLowerCase().startsWith("y");
		}
		return contestants;
	}

	/**
	 * Checks athlete name validity.
	 * <p/>
	 * Since limiting names is a bad idea I'll just convert them to UTF-8 instead.
	 *
	 * @param name The string that is being checked.
	 * @return Returns the same string.
	 * @throws java.io.UnsupportedEncodingException
	 *          Is thrown when input data is in unsupported encoding.
	 */
	private String checkName(String name) throws UnsupportedEncodingException {
		byte[] nameUTF = name.getBytes("UTF-8");
		name = new String(nameUTF, "UTF-8");
		return name;
	}

	/**
	 * Checks athlete birth date validity.
	 *
	 * @param birthDate Holds the athlete's date of birth.
	 * @return Returns the same string.
	 * @throws java.text.ParseException Is thrown when the date is in wrong format.
	 */
	private String checkDate(String birthDate) throws ParseException {
		SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
		format.setLenient(false);
		try {
			format.parse(birthDate);
			return birthDate;
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Checks athlete's country code validity.
	 * <p/>
	 * Goes through a list ISO 2-letter country codes and checks for a match.
	 *
	 * @param country Holds the athlete's country.
	 * @return Returns the same string.
	 */
	private String checkCountry(String country) {
		String[] countries = Locale.getISOCountries();
		for (int i = 0; i < Locale.getISOCountries().length; i++) {
			if (countries[i].contains(country))
				return country;
		}
		return null;
	}

	/**
	 * Checks athlete's performance validity.
	 * <p/>
	 * Checks if the input the user gave is actually a number.
	 * If not, the user must try again.
	 *
	 * @param stringInput Holds the athlete's performance.
	 * @return Returns the same string.
	 */
	private Double checkIsNumber(String stringInput) {
		if (stringInput == null || Double.valueOf(stringInput) == null) {
			System.out.println("Error in input. Try again.");
			return 0.0;
		} else {
			return Double.valueOf(stringInput);
		}
	}

	/**
	 * Checks athlete's performance validity.
	 * <p/>
	 * Checks if the input the user gave is actually a number.
	 * If not, the user must try again.
	 * Is used when there is a track event which performance
	 * time can be over a minute.
	 *
	 * @param time Holds the athlete's performance.
	 * @return Returns the same string.
	 */
	private Double checkMinSec(String time) {
		String[] timeSplit;
		if (time.matches("^([0-9][0-9]|[0-9])[:]([0-5][0-9]|[0-9])[. ]([0-9][0-9][0-9]|[0-9][0-9]|[0-9])")) {
			timeSplit = time.split(":");
			return (double) Integer.parseInt(timeSplit[0]) * 60 + Double.parseDouble(timeSplit[1]);
		} else if (time == null || Double.valueOf(time) == null) {
			System.out.println("Error in input. Try again.");
			throw new NumberFormatException();
		} else {
			return Double.valueOf(time);
		}
	}
}