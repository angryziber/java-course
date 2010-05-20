package net.azib.java.students.t050720.homework;
import java.sql.*;
import java.util.ArrayList;

/**
 * DatabaseInput
 *
 * @author Marek
 */
public class DatabaseInput implements Input {
	
	public DatabaseInput(String params)
	{
		//
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
		dbConn = DriverManager.getConnection("jdbc:mysql://java.azib.net:3306/decathlon","java","java");
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
		DatabaseInput t = new DatabaseInput("");
		try {
			t.connect();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void readInto(ArrayList<Record> records) {
		// TODO Auto-generated method stub
		
	}
}
