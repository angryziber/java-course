package net.azib.java.students.t092877.homework;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Database {

	static Connection con = null;


	public static List<Athlete> input(Competition decathlon, String input) {

		List<Athlete> athletes = decathlon.getAthletesList();

		Properties propslist = loadProperties();
		connectToDatabase(propslist);

		// NB! NEED to recode this part to take new regex pattern into account
		if (input.matches("[1-9][0-9]*"))
			athletes = getResults(Integer.valueOf(input), null, decathlon);
		else {
			athletes = getResults(null, input, decathlon);
		}

		return athletes;
	}


	public static Properties loadProperties() {

		Properties props = new Properties();

		try {
			props.load(Database.class.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return props;
	}


	private static void connectToDatabase(Properties propslist) {

		String driver = propslist.getProperty("db.driver");
		String url = propslist.getProperty("db.url");
		String username = propslist.getProperty("db.username");
		String password = propslist.getProperty("db.password");

		try {

			Class.forName(driver);
		    con = DriverManager.getConnection(url, username, password);

		    if(!con.isClosed())
		    	System.out.println("Successfully connected to the database - " + url);

	    } catch(Exception e) {
	      System.err.println("Exception: " + e.getMessage());

	      try {
		        if(con != null)
		        	con.close();
		  } catch(SQLException exc) {}
	    }
	}


	private static ArrayList<Athlete> getResults(Integer id, String name, Competition decathlon) {

		String idQuery;
		if(id == null) {
			idQuery = "SELECT id FROM competitions WHERE name = '" + name + "'";
		} else {
			idQuery = id.toString();
		}

		ResultSet rs1 = null;

		try {

			Statement st1 = con.createStatement();
			rs1 = st1.executeQuery("SELECT competitions.name," +
										  "competitions.location," +
										  "competitions.date " +
								   "FROM competitions " +
								   "WHERE competitions.id IN (" + idQuery + ");");

			while (rs1.next()) {

				decathlon.setName(rs1.getString("name"));
				decathlon.setLocation(rs1.getString("location"));

				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				Date comp = rs1.getDate("date");
				String compDate = df1.format(comp);

				decathlon.setDate(compDate);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}


		ResultSet rs2 = null;

		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		ArrayList<Result> results;
		Athlete athlete;

		try {

			Statement st2 = con.createStatement();
			rs2 = st2.executeQuery("SELECT results.id," +
										"athletes.name athlete_name," +
										"athletes.dob date_of_birth," +
										"athletes.country_code," +
									 	"results.race_100m," +
									 	"results.long_jump," +
									 	"results.shot_put," +
										"results.high_jump," +
										"results.race_400m," +
										"results.hurdles_110m," +
										"results.discus_throw," +
										"results.pole_vault," +
										"results.javelin_throw," +
										"results.race_1500m " +
								 "FROM athletes," +
									  "results " +
								 "WHERE athletes.id = results.athlete_id " +
								 "AND results.competition_id IN (" + idQuery + ");");

			while (rs2.next()) {

//				DateFormat df2 = new SimpleDateFormat("dd.MM.yyyy");
//				Date born = rs2.getDate("date_of_birth");
//				String dateOfBirth = df2.format(born);

				athlete = new Athlete(rs2.getString("athlete_name"),
									  rs2.getDate("date_of_birth").toString(),
									  rs2.getString("country_code"));

				results = new ArrayList<Result>();

				int i = 5;
				for (Event event : Event.values()) {
					results.add(new Result(event, Utils.convertToProperUnits(String.valueOf(rs2.getDouble(i)), event.getType())));
					i++;
				}

				athlete.setResults(results);
				athletes.add(athlete);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return athletes;
	}
}