package net.azib.java.students.t050545.homework.loaders;

import net.azib.java.students.t050545.homework.sport.Person;
import net.azib.java.students.t050545.homework.sport.Sportman;
import net.azib.java.students.t050545.homework.sport.PointSystem.Discipline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.GregorianCalendar;

/**
 * DBLoader
 * 
 * @author libricon
 */
public class DBLoader extends DataChecker implements SportmanLoader {

	/**
	 * @throws SQLException 
	 * 
	 */
	public DBLoader() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://java.azib.net:3306/decathlon", "java", "java");
		}
		catch (Exception e) {
			System.err.println("DataBase error!");
			e.printStackTrace();
		}
	}

	Connection conn = null;

	@Override
	public Sportman nextSportman() throws Exception {
		Statement stmt = conn.createStatement();
		ResultSet resultset = stmt.executeQuery("SELECT A.name, A.dob, A.country_code, R.race_100m, R.long_jump, R.shot_put, R.high_jump, R.race_400m, R.hurdles_110m, R.discus_throw, R.pole_vault, R.javelin_throw, R.race_1500m FROM athletes AS A INNER JOIN results AS R ON A.id=R.athlete_id WHERE R.competition_id = 2");

		while (resultset.next()) {
			String name = resultset.getString("NAME");
			String country = resultset.getString("COUNTRY_CODE");
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date birthDay = resultset.getDate("DOB");
			//GregorianCalendar birthDate = new GregorianCalendar();
			//birthDate.setTime(df.parse(birthDay));
			
			for (Discipline dis : Discipline.values()) {
				System.out.println(resultset.getString(dis.toString()));
				
			}
			
			
			
			//Person person = new Person(name, country, birthDate);
			//Sportman sportman = new Sportman(,person);


		}
		
		conn.close();
		return null;
	}
	
	   
	  // SQL
	  /*SELECT A.name, A.dob, A.country_code, R.race_100m, R.long_jump,
	  R.shot_put, R.high_jump, R.race_400m, R.hurdles_110m, R.discus_throw,
	  R.pole_vault, R.javelin_throw, R.race_1500m FROM athletes AS A INNER JOIN
	  results AS R ON A.id=R.athlete_id WHERE R.competition_id = 2*/
	 


	  
	   
	
}
