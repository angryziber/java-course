package net.azib.java.students.t050545.homework.loaders;

import net.azib.java.students.t050545.homework.sport.Discipline;
import net.azib.java.students.t050545.homework.sport.Person;
import net.azib.java.students.t050545.homework.sport.Score;
import net.azib.java.students.t050545.homework.sport.AthleteScore;
import net.azib.java.students.t050545.homework.utils.LoadException;
import net.azib.java.students.t050545.homework.utils.ReadException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Stack;

/**
 * DBLoader, load sportmans from database java.azib.net
 * 
 * @author libricon
 */
public class DBLoader implements AthleteLoader {

	/** resultset store response from database */
	private ResultSet resultset;
	/** stmt statement for database connection */
	private Statement stmt;
	/** conn connection itself */
	private Connection conn = null;
	/** baseQuery, need to add competition id */
	private String baseQuery = "SELECT A.name, A.dob, A.country_code, R.race_100m, R.long_jump, R.shot_put, R.high_jump, R.race_400m, R.hurdles_110m, R.discus_throw, R.pole_vault, R.javelin_throw, R.race_1500m FROM athletes AS A INNER JOIN results AS R ON A.id=R.athlete_id WHERE R.competition_id = ";

	private String argument = "-db";
	private String description = "<ID> Connect to database and load competitiona with ID";
	
	@Override
	public String getArgum() {
		return argument;
	}

	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * @return AthleteScore or null
	 */
	@Override
	public AthleteScore nextAthleteScore() throws ParseException, ReadException{

		try{
		
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
				birthDay = null;
			}
			GregorianCalendar birthDate = new GregorianCalendar();
			birthDate.setTime(df.parse(birthDay));

			float[] resultTable = new float[Discipline.values().length];
			for (Discipline dis : Discipline.values()) {
				resultTable[dis.ordinal()] = Float.parseFloat(resultset.getString(dis.toString()));
			}

			return (new AthleteScore(new Score(resultTable), new Person(name, country, birthDate.getTime())));

		}
		else {
			conn.close();
			return null;
		}
		}catch(SQLException e){
			throw new ReadException("Can't read from database");
		}
	}

	/** Open dataBase connection */
	@Override
	public void init(Stack<String> arguments) throws LoadException {
		try {
			String dataBaseID = arguments.pop();
			conn = DriverManager.getConnection("jdbc:mysql://java.azib.net:3306/decathlon", "java", "java");
			stmt = conn.createStatement();
			String query = baseQuery + dataBaseID;
			resultset = stmt.executeQuery(query);
			resultset.first();
		}
		catch (SQLException e) {
			throw new LoadException("Database error!!!");
		}
	}
	
	/** Close opened resouses */
	public void close(){
		try {
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
