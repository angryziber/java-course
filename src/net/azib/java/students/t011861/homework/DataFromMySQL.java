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
	 * @return List<String[]> array , which consists of data from MySql database!
	 */
	public List<String[]> getData() {
		return athletesData;
	}
	private Connection connect = null;
	private ResultSet resultSet = null;
	/**
	 * Creates connection with database to ask data. All data will be put in List array.
	 * @param Input is competitions id according to MySql database (compId).
	 */
	public DataFromMySQL(String compId) throws Exception 
	{
		try {
			ReadMySqlProperty mysqlStrings = new ReadMySqlProperty();
			String driver = mysqlStrings.getDriver();
			String url = mysqlStrings.getUrl();
			String user = mysqlStrings.getUser();
			String passwd = mysqlStrings.getPasswd();
			Class.forName(driver).newInstance();
			connect = DriverManager.getConnection(url+"?user="+user+"&password="+passwd);
			PreparedStatement statement = connect.prepareStatement("SELECT athletes.name AS name,athletes.dob AS birth,athletes.country_code AS c_code,results.race_100m AS a01,results.long_jump AS a02,results.shot_put AS a03,results.high_jump AS a04,results.race_400m AS a05,results.hurdles_110m AS a06,results.discus_throw AS a07,results.pole_vault AS a08,results.javelin_throw AS a09,results.race_1500m AS a10 FROM competitions INNER JOIN (results INNER JOIN athletes ON athletes.id = results.athlete_id) ON competitions.id = results.competition_id WHERE competitions.id="+compId);
			resultSet = statement.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData(); 
			columns = rsmd.getColumnCount();
			List<String> athleteData = new LinkedList<String>();
				while(resultSet.next())
				{ 	
					for (int i = 1; i < columns+1; i++ ) 
					{
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
			try {
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