package net.azib.java.students.t092860.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * InputFromDB
 *
 * @author scythe
 */
class InputFromDB implements Input {

	private static Logger logger = Logger.getLogger("global");
	
	public InputFromDB(String competitionId)
	{
		competition = competitionId;
	}
	
	public List<Data> get() throws Exception
	{
		List<Data> dataSet = new ArrayList<Data>();
		
		Connection conn = null;
	
		try
		{
			String connStr = "jdbc:" 
				+ getPropeties().getProperty("db.protocol", "mysql")
				+ "://" + getPropeties().getProperty("db.server", "java.azib.net")
				+ ":" + getPropeties().getProperty("db.port", "3306")
				+ "/" + getPropeties().getProperty("db.database", "decathlon")
				+ "?zeroDateTimeBehavior=convertToNull";
			
			String userName = getPropeties().getProperty("db.username");
			String password = getPropeties().getProperty("db.password");
			
			conn = DriverManager.getConnection(connStr, userName, password);
		}
		catch (Exception e)
		{
			throw new Exception("Cannot connect to database server. " + e.getMessage());
		}
		finally
		{
			if (conn != null)
			{
				try
				{
					Statement s = conn.createStatement ();
					s.executeQuery ("SELECT * FROM results " +
							"LEFT JOIN athletes ON results.athlete_id=athletes.id " +
							"LEFT JOIN competitions ON results.competition_id=competitions.id  " +
							"WHERE competitions.id=" + competition + " " +
							"OR competitions.name='" + competition +"'");
					ResultSet rs = s.getResultSet();
					try
					{
						while (rs.next())
						{
							dataSet.add(convert(rs));
						}
					}
					catch(Exception e){
						throw new Exception("Incorrect input data. " + e.getMessage());
					}
					finally{
						rs.close ();
					}
					   
					conn.close();
				}
				catch (Exception e) { 
					throw new Exception("Retrieving data from database failed. " + e.getMessage()); 
				}
			}
		}
		
		logger.info("data read from database");

		return dataSet;
	}
	
	private Data convert(ResultSet rs) throws Exception
	{
		Data athlete = new Data();
     			
		athlete.setName(rs.getString("athletes.name"));
		athlete.setDate(rs.getDate("athletes.dob"));
		athlete.setCountry(rs.getString("athletes.country_code"));
		athlete.addEvent(Events.RACE_100M, rs.getDouble("results.race_100m"));
		athlete.addEvent(Events.LONG_JUMP, rs.getDouble("results.long_jump"));
		athlete.addEvent(Events.SHOT_PUT, rs.getDouble("results.shot_put"));
		athlete.addEvent(Events.HIGH_JUMP, rs.getDouble("results.high_jump"));
		athlete.addEvent(Events.RACE_400M, rs.getDouble("results.race_400m"));
		athlete.addEvent(Events.HURDLES_110M, rs.getDouble("results.hurdles_110m"));
		athlete.addEvent(Events.DISCUS_THROW, rs.getDouble("results.discus_throw"));
		athlete.addEvent(Events.POLE_VAULT, rs.getDouble("results.pole_vault"));
		athlete.addEvent(Events.JAVELIN_THROW, rs.getDouble("results.javelin_throw"));
		athlete.addEvent(Events.RACE_1500M, rs.getDouble("results.race_1500m"));
		
		return athlete;
	}
	
	private Properties getPropeties() throws Exception
	{
		Properties dbprop = new Properties();	
		try {
			dbprop.load(this.getClass().getResourceAsStream("db.properties"));
		}
		catch (Exception e) {
			throw new Exception("Reading db.properties file failed. ");
		}	
		return dbprop;
	}

	private String competition;
}
