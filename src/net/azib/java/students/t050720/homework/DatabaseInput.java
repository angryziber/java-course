package net.azib.java.students.t050720.homework;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * DatabaseInput
 *
 * @author Marek
 */
public class DatabaseInput implements Input {
	
	private Properties dbProps;
	
	public DatabaseInput(String params) throws Exception
	{
		//
		dbProps = new Properties();
		FileInputStream in = new FileInputStream("src/net/azib/java/students/t050720/homework/db.properties");
		dbProps.load(in);
		in.close();
	}
/*
 * SELECT * 
FROM results
INNER JOIN athletes ON results.athlete_id = athletes.id
WHERE competition_id =1;

SELECT * 
FROM results 
INNER JOIN athletes ON results.athlete_id = athletes.id 
INNER JOIN competitions ON results.competition_id = competitions.id 
WHERE competitions.name = 'Training';
 */
	Connection dbConn;
	Statement st;
	
	void connect() throws SQLException
	{
		dbConn = DriverManager.getConnection(dbProps.getProperty("dburi"),dbProps.getProperty("dbuser"),dbProps.getProperty("dbpassword"));
		st = dbConn.createStatement();
//		ResultSet rs = st.executeQuery("SELECT * FROM results");
		ResultSet rs = st.executeQuery("SELECT * FROM results INNER JOIN athletes ON results.athlete_id = athletes.id WHERE competition_id =2;"
);
		while (rs.next()){
	        System.out.println(rs.getString("race_1500m")+rs.getString("name"));
	      }
		dbConn.close();
	}
	
	int stub()
	{
		return 0;
	}
	
	public static void main(String[] args)
	{
		try {
		DatabaseInput t = new DatabaseInput("");
			t.connect();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void readInto(ArrayList<Record> records) {
		// TODO Auto-generated method stub
		
	}
}
