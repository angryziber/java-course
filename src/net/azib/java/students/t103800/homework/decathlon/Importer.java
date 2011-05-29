package net.azib.java.students.t103800.homework.decathlon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.ParseException;
import java.util.*;

import net.azib.java.students.t103800.homework.decathlon.argument.Argument;
import net.azib.java.students.t103800.homework.decathlon.argument.ArgumentException;

/**
 * This class is used to import data in different ways. This class uses the singleton pattern.
 * It is possible to import data from databases(using the db.properties file), from CSV files and
 * from console input.
 *
 * @see Argument
 * @see Athlete
 *
 * @author Jaan Aigro
 * @version 1.0
 * @since 27/05/2011
 */
public class Importer {

	private static final String DB_PROPERTIES = "db.properties";

	private static Importer importer = null;

	private Importer() {}

	/**
	 * Obtain a reference to the importer singleton.
	 * @return importer.
	 */
	public static Importer getImporter() {
		if(importer == null) importer = new Importer();
		return importer;
	}

	/**
	 * Imports data about athletes into an array that consists of athlete objects.
	 * @param inputArgument the argument that contains information how the importer should import the data.
	 * @return data array of athlete objects.
	 * @throws ArgumentException throws when there is a problem with the parameter of the argument. For example, the
	 * file that it is pointing to, is missing.
	 * @throws ImporterException throws when importing data has failed.
	 */
	public Athlete[] importAthletes(Argument inputArgument) throws ArgumentException, ImporterException {
		try {
			switch(inputArgument.getMethod()) {
			case CONSOLE:
				return getDataFromConsole(System.in);
			case CSV:
				return getDataFromCSVFile(new FileInputStream(inputArgument.getParameter()));
			case DB:
				return getDataFromDB(inputArgument.getParameter(), Importer.class.getResourceAsStream(DB_PROPERTIES));
			default:
				throw new ArgumentException("Method " + inputArgument.getMethod() + " can not be used as input method.");
			}
		} catch (FileNotFoundException e) {
			throw new ArgumentException("Could not find file(input): " + e.getMessage());
		}
	}

	/**
	 * Parses data from the console(stream) by asking questions.
	 * @param consoleInputStream stream to scan data from.
	 * @return information about athletes.
	 */
	public Athlete[] getDataFromConsole(InputStream consoleInputStream) {
		ArrayList<Athlete> athleteList = new ArrayList<Athlete>();
		Scanner scanner = new Scanner(consoleInputStream);
		Athlete athlete;

		System.out.println("Add interactively athletes and their results:");
		while(true) {
			athlete = new Athlete();
			for(QuestionEnum question : QuestionEnum.values()) athlete = askQuestion(scanner, athlete, question);
			athleteList.add(athlete);
			if(!askForAnotherAthlete(scanner)) break;
		}
		scanner.close();

		Athlete[] athletes = new Athlete[athleteList.size()];
		athleteList.toArray(athletes);
		return athletes;
	}

	/**
	 * Parses data from a CSV file.
	 * @param fileStream stream to parse data from.
	 * @return information about athletes.
	 * @throws ImporterException thrown when importing and validation of data has failed.
	 */
	public Athlete[] getDataFromCSVFile(InputStream fileStream) throws ImporterException {
		ArrayList<Athlete> athleteList = new ArrayList<Athlete>();
		BufferedReader csvReader = null;
		String line;
		StringTokenizer tokens;
		Athlete athlete;

		try {
			csvReader = new BufferedReader(new InputStreamReader(fileStream));
			csvReader.read();
			while((line = csvReader.readLine()) != null) {
				tokens = new StringTokenizer(line, ",");
				athlete = new Athlete();

				athlete.setName(tokens.nextToken().trim());
				athlete.setBirthDate(tokens.nextToken());
				athlete.setCountryCode(tokens.nextToken());
				for(Athlete.Event event : Athlete.Event.values()) athlete.setResult(event, tokens.nextToken());

				athleteList.add(athlete);
			}
		} catch (ParseException e) {
			throw new ImporterException("Parsing error: " + e.getMessage());
		} catch (IOException e) {
			throw new ImporterException("IOError: " + e.getMessage());
		} catch (CountryCodeException e) {
			throw new ImporterException("Parsing error: " + e.getMessage());
		} finally {
			try {
				if(csvReader != null) csvReader.close();
			} catch (IOException ignored) {}
		}

		Athlete[] athletes = new Athlete[athleteList.size()];
		athleteList.toArray(athletes);
		return athletes;
	}

	/**
	 * Connects to the database specified in the first line of the properties stream and downloads data about athletes
	 * and the competition.
	 *
	 * @param competition Competition to select. You can also enter the id number of the competition.
	 * @param properties reads the first line in this stream. This line is used as a connection string.
	 * @return information about athletes.
	 * @throws ImporterException thrown when importing and/or validation of data has failed.
	 */
	public Athlete[] getDataFromDB(String competition, InputStream properties) throws ImporterException {
		Map<Integer, Athlete> athleteMap = new HashMap<Integer, Athlete>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(properties));
		Connection connection = null;
		Athlete athlete;
		int competitionID = -1;

		try { competitionID = Integer.parseInt(competition); } catch (NumberFormatException ignored) {}

		try {
			connection = DriverManager.getConnection(reader.readLine());
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT id,name FROM competitions");
			
			while(resultSet.next()) {
				if(competitionID != -1) {
					if(resultSet.getInt(1) == competitionID) break;
				} else if (resultSet.getString(2).toLowerCase().equals(competition.toLowerCase())) {
						competitionID = resultSet.getInt(1);
						break;
				}
				if (resultSet.isLast()) throw new ImporterException("No such competition(" + competition + ") found.");
			}

			resultSet = statement.executeQuery("SELECT athlete_id,race_100m,long_jump,shot_put,high_jump,race_400m," +
					"hurdles_110m,discus_throw,pole_vault,javelin_throw,race_1500m FROM results WHERE competition_id=" +
					"'" + competitionID + "'");

			while(resultSet.next()) {
				athlete = new Athlete();
				for(Athlete.Event event : Athlete.Event.values()) athlete.setResult(event,
						resultSet.getFloat(event.ordinal() + 2));
				athleteMap.put(resultSet.getInt(1), athlete);
			}

			for(Map.Entry<Integer, Athlete> entry : athleteMap.entrySet()) {
				resultSet = statement.executeQuery("SELECT name,dob,country_code FROM athletes WHERE " +
						"id='" + entry.getKey() + "'");
				resultSet.next();
				try {
					entry.getValue().setName(resultSet.getString(1));
					entry.getValue().setBirthDate(resultSet.getString(2));
					entry.getValue().setCountryCode(resultSet.getString(3));
				} catch (ParseException e) {
					throw new ImporterException("Birth date is in bad format: " + e.getMessage());
				} catch (CountryCodeException e) {
					throw new ImporterException("Country code is in bad format: " + e.getMessage());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ImporterException("Caught SQL error. " + e.getMessage());
		} catch (IOException e) {
			throw new ImporterException("Failed to read db.properties file: " + e.getMessage());
		} finally {
			if(connection != null) try {
				connection.close();
			} catch (SQLException ignored) {}
		}

		Athlete[] athletes = new Athlete[athleteMap.size()];
		athleteMap.values().toArray(athletes);
		return athletes;
	}

	/**
	 * Asks a yes/no question. Repeats until it has successfully parsed the answer.
	 * @param scanner scanner to scan answer from.
	 * @return true if yes, false if no.
	 */
	public boolean askForAnotherAthlete(Scanner scanner) {
		while(true) {
			System.out.print("Do you want to enter another athlete?(yes/no): ");
			String answer = scanner.nextLine().toLowerCase();
			if(answer.equals("yes") || answer.equals("no")) {
				return answer.equals("yes");
			}else System.out.println("You must answer yes or no, try again.");
		}
	}

	/**
	 * Asks a certain question about the athlete and adds it to the athlete object.
	 * Returns a copy of the object with the result of the question that modified data in the athlete object.
	 * @param scanner scanner to scan answers from.
	 * @param athlete athlete to add the question answer to.
	 * @param question question to print and ask.
	 * @return a copy of the athlete with a certain modified information field depending on the question.
	 */
	public Athlete askQuestion(Scanner scanner, Athlete athlete, QuestionEnum question) {
		while(true) {
			try {
				System.out.print(question.question);
				switch(question) {
				case NAME:
					athlete.setName(scanner.nextLine());
					return athlete;
				case BIRTHDATE:
					athlete.setBirthDate(scanner.nextLine());
					return athlete;
				case COUNTRY:
					athlete.setCountryCode(scanner.nextLine());
					return athlete;
				default:
					athlete.setResult(question.event, scanner.nextLine());
					return athlete;
				}
			} catch(Exception e) {
				System.out.println("You made a mistake. Try again.");
			}
		}
	}

	/**
	 * This enumeration is used to store data about questions. Since most of the questions are about event results then
	 * there is an additional field describing the event.
	 *
	 * @see Athlete.Event
	 *
	 * @author Jaan Aigro
	 * @version 1.0
	 * @since 23/05/2011
	 */
	private enum QuestionEnum {
		NAME("Name: ", null),
		BIRTHDATE("Date of birth(date.month.year): ", null),
		COUNTRY("2-letter country code: ", null),
		SPRINT100M("100m sprint result(mins:seconds): ", Athlete.Event.SPRINT100M),
		LONGJUMP("Long jump result(meters): ", Athlete.Event.LONGJUMP),
		SHOTPUT("Shotput result(meters): ", Athlete.Event.SHOTPUT),
		HIGHJUMP("High jump result(meters): ", Athlete.Event.HIGHJUMP),
		SPRINT400M("400m sprint result(mins:seconds): ", Athlete.Event.SPRINT400M),
		HURDLES110M("110m hurdles result(mins:seconds): ", Athlete.Event.HURDLES110M),
		DISCUSTHROW("Discus throwing result(meters): ", Athlete.Event.DISCUSTHROW),
		POLEVAULT("Pole vault result(meters): ", Athlete.Event.POLEVAULT),
		JAVELINTHROW("Javelin throwing result(meters): ", Athlete.Event.JAVELINTHROW),
		RACE1500M("1500m race result(mins:seconds): ", Athlete.Event.RACE1500M);

		private String question;
		private Athlete.Event event;

		/**
		 * Creates a new item into the enumeration with the question and event that it is related to.
		 * @param question question.
		 * @param event event that the question is related to.
		 */
		QuestionEnum(String question, Athlete.Event event) {
			this.question = question;
			this.event = event;
		}
	}
}