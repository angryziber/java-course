package net.azib.java.students.t011861.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * DataFromMySQL
 *
 * @author t011861
 */

public class DataFromMySQL {
	List<String[]> athletesData = new LinkedList<String[]>();
	private int columns = 0;
	/**
	 * Get data, every athlete's data is one array of strings
	 * @return List<String[]> athletes
	 */
	public List<String[]> getData() {
		return athletesData;
	}
	
	private Connection connect = null;
	private ResultSet resultSet = null;
	
	public DataFromMySQL() throws Exception 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection("jdbc:mysql://srv.azib.net:3306/decathlon?"+"user=java&password=java");
			PreparedStatement statement = connect.prepareStatement("SELECT athletes.name AS name,athletes.dob AS birth,athletes.country_code AS c_code,results.race_100m AS a01,results.long_jump AS a02,results.shot_put AS a03,results.high_jump AS a04,results.race_400m AS a05,results.hurdles_110m AS a06,results.discus_throw AS a07,results.pole_vault AS a08,results.javelin_throw AS a09,results.race_1500m AS a10 FROM competitions INNER JOIN (results INNER JOIN athletes ON athletes.id = results.athlete_id) ON competitions.id = results.competition_id");
			resultSet = statement.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData(); 
			columns = rsmd.getColumnCount();
				List<String> athleteData = new LinkedList<String>();
				while(resultSet.next())
					{ 	
						for (int i = 1; i < columns+1; i++ ) 
						{
							System.out.println(resultSet.getString(1));
							athleteData.add(resultSet.getString(i));
						}
							athletesData.add((String[]) athleteData.toArray(new String[athleteData.size()]));
								athleteData.clear();		
					}
				statement.close();
			} 
		catch (ClassNotFoundException e) 
			{
				System.out.println("Can not find database driver! " + e);
			} 
		catch (SQLException e) 
			{
				System.out.println("Database access failed! " + e);
			} 
		finally 
			{
				try 
					{
						resultSet.close();
						connect.close();
						System.out.println("Database connection closed");
					} 
				catch (SQLException e) 
					{
						System.out.println("Failed to close database connection! " + e);
					}
			}
	}
}