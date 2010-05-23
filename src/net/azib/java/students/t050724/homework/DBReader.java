package net.azib.java.students.t050724.homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 * DBReader
 * 
 * @author xom
 */
public class DBReader {

	Connection conn = null;
	PreparedStatement stmt = null;
	String sql = "";

	SupportClass supporter = new SupportClass();

	/**
	 * Gets input data from database, checks it's validity, puts it into Athlete
	 * object and returns the object.
	 * 
	 * @param competition
	 *            String representation of the competition name or ID, of which
	 *            to get the data.
	 * @return Athlete object that has been filled with input data.
	 */
	protected ArrayList<Athlete> getDataFromDB(String competition) {

		ArrayList<Athlete> athletes = new ArrayList<Athlete>();

		int competitionID = 0;

		getConnection();

		try {
			competitionID = Integer.parseInt(competition);
		}
		catch (Exception e) {
			competitionID = getCompetitionID(competition);
		}

		athletes = getAthletesResults(competitionID, athletes);

		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				System.out.println("Database closing failed!");
			}
		}

		return athletes;
	}

	private void getConnection() {

		Properties props = new Properties();

		try {
			FileInputStream in = new FileInputStream(supporter.setFilePath("db.properties"));
			props.load(in);
			in.close();
		}
		catch (IOException e) {
			System.out.println("Cannot find db.properties file!");
		}

		String drivers = props.getProperty("jdbc.drivers");
		if (drivers != null) {
			System.setProperty("jdbc.drivers", drivers);
		}

		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");

		try {
			conn = DriverManager.getConnection(url, username, password);
		}
		catch (SQLException e) {
			System.out.println("Unable to connect to database!");
		}
	}

	private int getCompetitionID(String comp) {

		ArrayList<Integer> IDs = new ArrayList<Integer>();

		int ID = 0;

		try {
			sql = "SELECT id FROM competitions WHERE name = ?";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, comp);

			ResultSet rsCompetition = stmt.executeQuery();

			while (rsCompetition.next()) {

				ID = rsCompetition.getInt("id");

				IDs.add(ID);
				System.out.println();

			}
			rsCompetition.close();
		}
		catch (SQLException e) {
			System.out.println("Unable to get Competition info!");
		}

		if (IDs.size() > 1) {

			Scanner sc = new Scanner(System.in);
			String inputID = "";

			System.out.println("There are " + IDs.size() + " competitions with that name, which ID's are:");
			for (Integer id : IDs) {
				System.out.println(id);
			}

			System.out.println("Choose an ID!");

			while (true) {
				inputID = sc.nextLine();

				for (Integer id : IDs) {
					if (id.toString().equals(inputID)) {
						ID = Integer.valueOf(id);
						return ID;
					}
				}
				System.out.println("Insert correct ID!");
			}
		}
		else {
			return ID;
		}
	}

	private ArrayList<Athlete> getAthletesResults(int compID, ArrayList<Athlete> athletes) {

		try {
			sql = "SELECT A.name, A.dob, A.country_code, " + "R.race_100m, R.long_jump, R.shot_put, R.high_jump, R.race_400m, "
					+ "R.hurdles_110m, R.discus_throw, R.pole_vault, R.javelin_throw, R.race_1500m "
					+ "FROM athletes AS A INNER JOIN results AS R ON A.id = R.athlete_id WHERE R.competition_id = ?";

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, compID);

			ResultSet rsComp = stmt.executeQuery();

			if (!rsComp.next()) {
				System.out.println("There are no results for this competition!");
			}
			else {
				do {

					Athlete athleteFromDB = new Athlete();

					boolean allOK = false;

					try {
						athleteFromDB.setName(rsComp.getString("A.name"));

						athleteFromDB.setDate(rsComp.getDate("A.dob"));

						athleteFromDB.setCountry(supporter.checkAthleteCountry(rsComp.getString("A.country_code")));

						athleteFromDB.setHm(rsComp.getDouble("R.race_100m"));

						athleteFromDB.setLongJump(rsComp.getDouble("R.long_jump"));

						athleteFromDB.setShotPut(rsComp.getDouble("R.shot_put"));

						athleteFromDB.setHighJump(rsComp.getDouble("R.high_jump"));

						athleteFromDB.setFhm(rsComp.getDouble("R.race_400m"));

						athleteFromDB.setHtmHurdles(rsComp.getDouble("R.hurdles_110m"));

						athleteFromDB.setDiscusThrow(rsComp.getDouble("R.discus_throw"));

						athleteFromDB.setPoleVault(rsComp.getDouble("R.pole_vault"));

						athleteFromDB.setJavelinThrow(rsComp.getDouble("R.javelin_throw"));

						athleteFromDB.setTfhm(rsComp.getDouble("R.race_1500m"));

						allOK = true;
					}
					catch (Exception e) {
						System.out.println("There is some bad data in " + rsComp.getString("A.name")
								+ "'s results, omitting it...");
					}

					if (allOK) {
						athletes.add(athleteFromDB);
					}
					athleteFromDB = null;

				}
				while (rsComp.next());
			}

			rsComp.close();
		}
		catch (Exception e) {
			System.out.println("Unable to get athletes results!");
		}

		return athletes;
	}

}
