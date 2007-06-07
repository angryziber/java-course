package net.azib.java.students.t030630.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * a class that handles input data(from keyboard, CSV file or MySQL database),
 * computes places got by athletes and generates output data(to console, CSV
 * file, XML or HTML file). Methods are public to make easier of wtiting JUnit
 * tests (otherwise they must be private)
 * 
 * @author Sergei
 */
public class IOHandler {

	private Collection<Athlete> athletes;

	public IOHandler() {
		athletes = new TreeSet<Athlete>(new Comparator<Athlete>() {
			@Override
			public int compare(Athlete o1, Athlete o2) {
				if (o2.getPoints() != o1.getPoints()) {
					if (o2.getName().hashCode() == o1.getName().hashCode()
							&& o2.getDateOfBirth().hashCode() == o1.getDateOfBirth().hashCode()
							&& o2.getCountry().hashCode() == o1.getCountry().hashCode())
						return 0;
					return o2.getPoints() - o1.getPoints();
				}
				else if (o2.getName().hashCode() != o1.getName().hashCode())
					return o2.getName().hashCode() - o1.getName().hashCode();
				else if (o2.getDateOfBirth().hashCode() != o1.getDateOfBirth().hashCode())
					return o2.getDateOfBirth().hashCode() - o1.getDateOfBirth().hashCode();
				else
					return o2.getCountry().hashCode() - o1.getCountry().hashCode();
			}
		});
	}

	public Collection<Athlete> getAthletes() {
		return athletes;
	}

	public void setAthletes(Collection<Athlete> athletes) {
		this.athletes = athletes;
	}

	/**
	 * Defines, what athlete has taken what place at competition, a few athletes
	 * can share the same place.
	 */
	public void setPlacesToAthletes() {
		String[] places = new String[athletes.size()];
		int i = 1;
		int prev = 0;
		int k = 1;
		for (Athlete athlete : athletes) {
			places[i - 1] = Integer.toString(i);
			if (i != 1) {
				if (athlete.getPoints() != prev) {
					if (k != i - 1) {
						for (int j = k - 1; j < i - 1; j++)
							// share places
							places[j] = Integer.toString(k) + "-" + Integer.toString(i - 1);
						k = i - 1;
					}
					k++;
				}
				else if (i == places.length) {
					for (int j = k - 1; j < i; j++)
						places[j] = Integer.toString(k) + "-" + Integer.toString(i);
				}
			}
			prev = athlete.getPoints();
			i++;
		}

		i = 0;
		for (Athlete athlete : athletes) {
			athlete.setPlace(places[i]);
			i++;
		}
	}

	/**
	 * runs Console Dialog, where you can select input data source and output
	 * data destination (interface of Decathlon calculator program)
	 */
	public void runConsoleDialog() {

		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println("\\*** Welcome to Decathlon calculator! ***/\n");

		InputStream in = System.in;
		Scanner scanner = new Scanner(in);

		do {
			pw.println("Select the input data source:\n" + "* Keyboard (k)\n* MySQL database (d)\n* File (f) (default)");
			char inputSource = scanner.nextLine().charAt(0);

			// input data sourse
			switch (inputSource) {
			case 'k':
				pw.println("Enter input data using keyboard. To stop writing, enter \"q\".");
				String input;
				Athlete athlete;
				while (!(input = scanner.nextLine()).equals("q")) {
					athlete = new Athlete(input);
					if (athlete.isDataCorrect())
						athletes.add(athlete);
					else
						System.err.println("Try enter input data for athlete one more time");
				}
				;
				break;
			case 'd':
				pw.println("Input data will be loaded from a MySQL database.\n Indicate the Competition Name:");
				do {
					pw.println("* Training in Tallinn (1)\n* DECATHLON4BEER in Krakow (2)");
					inputSource = scanner.nextLine().charAt(0);
				}
				while (inputSource != '1' && inputSource != '2');
				readInputFromMySQLDatabase(inputSource == '1' ? "Training in Tallinn" : "DECATHLON4BEER in Krakow");
				break;
			case 'f':
				pw.println("Input data will be loaded from a file.\nIndicate input file path with file extension .csv:");
				while (!readInputFromCSVFile(scanner.nextLine()))
					System.err.println("Indicate another input file");
				break;
			default:
				break;
			}

			pw.println("Input data got");

			setPlacesToAthletes();

			// output data source
			pw.println("\n" + "Select the output data destination:\n"
					+ "* Console (c)\n* XML file (x)\n* HTML file (h)\n* CSV file (f) (default)");
			switch (scanner.nextLine().charAt(0)) {
			case 'c':
				pw.println("Output data is written to console:");
				writeOutputToConsole();
				break;
			case 'x':
				pw.println("Output data will be saved to XML file:\nIndicate the output file path with file extension .xml:");
				String xmlFileName = scanner.nextLine();
				if (!xmlFileName.contains(".xml"))
					xmlFileName.concat(".xml");
				new XMLHTMLGenerator(xmlFileName, athletes);
				break;
			case 'h':
				pw
						.println("Output data is saved to HTML file:\nIndicate the output file path with file extension .html\n(XML file will be also created):");
				String htmlFileName = scanner.nextLine();
				if (!htmlFileName.contains(".html"))
					htmlFileName.concat(".html");
				new XMLHTMLGenerator(htmlFileName, athletes);
				break;
			case 'f':
			default:
				pw.println("Output data is written to CSV file:\nIndicate the output file path with file extension .csv:");
				while (!writeOutputToCSVFile(scanner.nextLine()))
					System.err.println("Indicate another output file");
				break;
			}

			pw.println("\nSelect next step:\n* Exit (e)\n* Use decathlon calculator once more (any key)");
			athletes.clear();

		}
		while (scanner.nextLine().charAt(0) != 'e');
		pw.close();
	}

	/**
	 * reads input data from a CSV file and stores information about athletes in
	 * athletes(TreeSet<Athlete>), returns false if reading fails
	 * 
	 * @param fileName
	 *            a input CSV file name
	 * @throws FileNotFoundException
	 * @throws IOException
	 *             failed to read file
	 * @return true, if data are read and are in correct format
	 */
	public boolean readInputFromCSVFile(String fileName) {

		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
			String line = "";
			int lineNumber = 1;
			Athlete athlete;
			while ((line = bufferedReader.readLine()) != null) {
				athlete = new Athlete(line);
				if (athlete.isDataCorrect())
					athletes.add(athlete);
				else
					System.err.println("Input data on line " + lineNumber + " have incorrect format and omitted.");
				lineNumber++;
			}
			bufferedReader.close();

		}
		catch (FileNotFoundException e) {
			System.err.println("File \"" + fileName + "\" is not found");
			return false;
		}
		catch (IOException e) {
			System.err.println("Failed to read file \"" + fileName + "\"");
			return false;
		}
		return true;

	}

	/**
	 * writes information about athletes stored in athletes(TreeSet<Athlete>)
	 * to a CSV file, returns false if writing fails
	 * 
	 * @param fileName
	 *            a output CSV file name
	 * @throws FileNotFoundException
	 * @throws IOException
	 *             failed to write to file
	 * @return true, if data are written in file
	 */
	public boolean writeOutputToCSVFile(String fileName) {
		try {
			BufferedWriter outToFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
			for (Athlete athlete : athletes) {
				outToFile.write(athlete.getAthletePersonalInfoAndResults() + "\n");
			}
			outToFile.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("File \"" + fileName + "\" is not found");
			return false;
		}
		catch (IOException e) {
			System.err.println("Failed to write to file \"" + fileName + "\"");
			return false;
		}
		return true;
	}

	/**
	 * writes information about athletes stored in athletes(TreeSet<Athlete>)
	 * to console
	 * 
	 * @throws UnsupportedEncodingException
	 *             if UTF8 is not supported
	 */
	public void writeOutputToConsole() {
		PrintWriter pw;
		try {
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8")), true);

			for (Athlete athlete : athletes) {
				pw.println(athlete.getAthletePersonalInfoAndResults());
			}
		}
		catch (UnsupportedEncodingException e) {
			System.err.println("UTF-8 is not supported");
		}
	}

	/**
	 * reads input data from MySQL database and stores information about
	 * athletes in athletes(TreeSet<Athlete>), returns false if reading from
	 * database fails
	 * 
	 * @author Igor, Sergei
	 * @param competitionName
	 *            name of competion (in database might be stored results of a
	 *            few competitions)
	 * @throws NumberFormatException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return true, if data are read and are in correct format
	 */
	public boolean readInputFromMySQLDatabase(String competitionName) {
		// Training in Tallinn OR DECATHLON4BEER in Krakow
		Statement stmtAthleteresults, stmtAthleteInfo;
		ResultSet rsAthleteResults = null;
		ResultSet rsAthleteInfo = null;
		Athlete athlete;
		int id = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://srv.azib.net:3306/decathlon?useUnicode=true&characterEncoding=UTF8";
			Connection con;
			con = DriverManager.getConnection(url, "java", "java");

			// Get a Statement object
			stmtAthleteresults = con.createStatement();
			rsAthleteResults = stmtAthleteresults.executeQuery("SELECT * FROM competitions WHERE description='" + competitionName
					+ "'");
			while (rsAthleteResults.next()) {
				id = rsAthleteResults.getInt("id");
			}
			rsAthleteResults = stmtAthleteresults.executeQuery("SELECT * FROM results WHERE competition_id='" + id + "'");
			while (rsAthleteResults.next()) {
				StringBuilder data = new StringBuilder();
				int id2 = rsAthleteResults.getInt("athlete_id");
				stmtAthleteInfo = con.createStatement();
				rsAthleteInfo = stmtAthleteInfo.executeQuery("SELECT * FROM athletes WHERE id='" + id2 + "'");
				while (rsAthleteInfo.next()) {
					String[] dob = rsAthleteInfo.getString("dob").split("-");
					data.append(rsAthleteInfo.getString("name") + "," + dob[2] + "." + dob[1] + "." + dob[0] + ","
							+ rsAthleteInfo.getString("country_code") + ",");
				}
				try {
					data.append(rsAthleteResults.getFloat("race_100m") + "," + rsAthleteResults.getFloat("long_jump") + ","
							+ rsAthleteResults.getFloat("shot_put") + "," + rsAthleteResults.getFloat("high_jump") + ","
							+ rsAthleteResults.getFloat("race_400m") + "," + rsAthleteResults.getFloat("hurdles_110m") + ","
							+ rsAthleteResults.getFloat("discus_throw") + "," + rsAthleteResults.getFloat("pole_vault") + ","
							+ rsAthleteResults.getFloat("javelin_throw") + "," + rsAthleteResults.getFloat("race_1500m"));
				}
				catch (NumberFormatException e) {
					System.err.println("Incorrect data format while reading competition results for athlete with id=" + id2);

				}
				athlete = new Athlete(data.toString());
				if (athlete.isDataCorrect())
					athletes.add(athlete);
			}
			con.close();

		}
		catch (ClassNotFoundException e) {
			System.err.println("Class \"com.mysql.jdbc.Driver\" was not found");
			return false;
		}
		catch (SQLException e) {
			System.err.println("Cannot connect to SQL data base ");
			return false;
		}
		return true;
	}
}
