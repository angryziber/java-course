package net.azib.java.students.t050720.homework;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * <b>DatabaseInput</b>
 * Handles input from database. Database connection parameters are read from the db.properties file.
 * Gathers results from a single competition identified by either an ID or name.
 * The class makes do with a single database query (albeit with JOINs).
 *
 * @author Marek
 */
public class DatabaseInput implements Input {
	
	private Properties dbProps;
	private Connection dbConn;
	private Statement st;
	private String query;
	
	/**
	 * Reads properties from file and assembles database query according to the params argument.
	 * 
	 * @param params is the competition name or ID. If it is a number, it is used as an ID
	 * and otherwise a name. The database query is assembled accordingly.
	 * @throws Exception
	 */
	public DatabaseInput(String params) throws Exception
	{
		dbProps = new Properties();
		InputStream in = getClass().getResourceAsStream("db.properties");// fixed: new FileInputStream("src/net/azib/java/students/t050720/homework/db.properties");
		dbProps.load(in);
		in.close();
		
		if(Pattern.matches("^\\d*$", params))
		{
			query = new String("SELECT * FROM results INNER JOIN athletes ON results.athlete_id = athletes.id WHERE competition_id = " + params + ";");
		}
		else
		{
			query = new String("SELECT * FROM results INNER JOIN athletes ON results.athlete_id = athletes.id INNER JOIN competitions ON results.competition_id = competitions.id WHERE competitions.name = '"+params+"';");
		}
	}

	/**
	 * Connects to the database, executes the predefined query and processes the results.
	 * The query results are parsed into the passed ArrayList of Record.
	 * If the date-of-birth conversion from sql.Date to java.util.Date fails, a default date of 01.01.1900 is used.
	 *  
	 * @param records is a reference to the list that gets populated.
	 * @throws Exception
	 */
	@Override
	public void readInto(ArrayList<Record> records) throws Exception {
		
		dbConn = DriverManager.getConnection(dbProps.getProperty("dburi"),dbProps.getProperty("dbuser"),dbProps.getProperty("dbpassword"));
		st = dbConn.createStatement();

		ResultSet rs = st.executeQuery(query);
		while (rs.next()){
			Record rec = new Record();
			rec.setAthlete(rs.getString("athletes.name"));
			
			SimpleDateFormat df=new SimpleDateFormat("dd.MM.yyyy");
			Calendar c=Calendar.getInstance();
			try {
				c.setTime( new Date(java.sql.Date.valueOf(rs.getString("athletes.dob")).getTime()) );
				rec.setBirthDate(df.format(c.getTime()));
			} catch(SQLException e) {
				rec.setBirthDate("01.01.1900");
			}
			
			rec.setCountry(rs.getString("athletes.country_code"));
			rec.setRace_100m(rs.getFloat("results.race_100m"));
			rec.setLong_jump(rs.getFloat("results.long_jump"));
			rec.setShot_put(rs.getFloat("results.shot_put"));
			rec.setHigh_jump(rs.getFloat("results.high_jump"));
			rec.setRace_400m(rs.getFloat("results.race_400m"));
			rec.setHurdles_110m(rs.getFloat("results.hurdles_110m"));
			rec.setDiscus_throw(rs.getFloat("results.discus_throw"));
			rec.setPole_vault(rs.getFloat("results.pole_vault"));
			rec.setJavelin_throw(rs.getFloat("results.javelin_throw"));
			rec.setRace_1500m(rs.getFloat("results.race_1500m"));	
	        records.add(rec);
	      }
		dbConn.close();	
	}
}
