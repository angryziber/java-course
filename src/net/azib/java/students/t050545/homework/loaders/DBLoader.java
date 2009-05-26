package net.azib.java.students.t050545.homework.loaders;

import net.azib.java.students.t050545.homework.sport.Person;
import net.azib.java.students.t050545.homework.sport.Score;
import net.azib.java.students.t050545.homework.sport.Sportman;
import net.azib.java.students.t050545.homework.sport.PointSystem.Discipline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.GregorianCalendar;

/**
 * DBLoader
 * 
 * @author libricon
 */
public class DBLoader extends DataChecker implements SportmanLoader {

	
	/** Cometition ID is id, what is putted into database
	 * @throws SQLException
	 */
	public DBLoader(String compID) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://java.azib.net:3306/decathlon", "java", "java");
		}
		catch (Exception e) {
			System.err.println("DataBase error!");
			e.printStackTrace();
		}
		stmt = conn.createStatement();
		String query = baseQuery + compID;
		resultset = stmt.executeQuery(query);
		resultset.first();
	}

	/**
	 * Method return next sportman, if ther is no more, return null
	 * 
	 * @return Sportman or null
	 */
	@Override
	public Sportman nextSportman() throws SQLException, ParseException {

		if (resultset.next()) {
			String name;
			String country;
			String birthDay = null;

			name = resultset.getString("NAME");
			country = resultset.getString("COUNTRY_CODE");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			try {
				birthDay = resultset.getString("DOB");
			}
			catch (Exception e) {
				System.err.println("Wrong birthday in dataBase! " + name + " " + birthDay);
				birthDay = "1111-11-11";
			}
			GregorianCalendar birthDate = new GregorianCalendar();
			birthDate.setTime(df.parse(birthDay));

			float[] resultTable = new float[Discipline.values().length];
			for (Discipline dis : Discipline.values()) {
				resultTable[dis.ordinal()] = Float.parseFloat(resultset.getString(dis.toString()));
			}

			return (new Sportman(new Score(resultTable), new Person(name, country, birthDate)));

		}
		else {
			conn.close();
			return null;
		}

	}

	// SQL
	/*
	 * SELECT A.name, A.dob, A.country_code, R.race_100m, R.long_jump,
	 * R.shot_put, R.high_jump, R.race_400m, R.hurdles_110m, R.discus_throw,
	 * R.pole_vault, R.javelin_throw, R.race_1500m FROM athletes AS A INNER JOIN
	 * results AS R ON A.id=R.athlete_id WHERE R.competition_id = 2
	 */

	ResultSet resultset;
	Statement stmt;
	Connection conn = null;
	String baseQuery = "SELECT A.name, A.dob, A.country_code, R.race_100m, R.long_jump, R.shot_put, R.high_jump, R.race_400m, R.hurdles_110m, R.discus_throw, R.pole_vault, R.javelin_throw, R.race_1500m FROM athletes AS A INNER JOIN results AS R ON A.id=R.athlete_id WHERE R.competition_id = ";

}
