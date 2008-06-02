package net.azib.java.students.t020281.homework;

import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * SportsmanDAO
 *
 * @author Trial
 */
public class SportsmanDAO {
	
	ArrayList<Results> resultList = null;
	String url;
	String user;
	String password;
	
	/**
	 * 
	 */
	public SportsmanDAO() {
		resultList = new ArrayList<Results>();
		Properties pr = new Properties();
		InputStream in = null;
		try {
			in = SportsmanDAO.class.getResourceAsStream("db.properties");
			pr.load(in);
			url=pr.getProperty("url");
			user = pr.getProperty("user");
			password = pr.getProperty("pass");
		}
		catch (IOException e) {
			System.out.println("Error reading Database properties form file. IOError!");
		}
		finally{
			try {
				in.close();
			}
			catch (IOException e) {
				System.out.println("Error closing database properties file. IOError!");
			}
		}

	}
	
	/**
	 * Method for obtaining connection to database
	 * @return - connection handler
	 */
	private Connection connectDb(){
		
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		}
		catch (SQLException e) {
			System.out.println("Error connecting to database!");
			return null;
		}
	}
	
	/**
	 * Method for converting SQL date to another format.
	 * Example: 2006-07-27 to 27.07.2006
	 * @param date - SQL Date
	 * @return date string
	 */
	private String convertSQLDate(Date date){
		String[] arr= date.toString().split("\\-");
		return arr[2]+"."+arr[1]+"."+arr[0];
	}
	
	/**
	 * Method reads Sportsmen data to string array in CSV format from database.
	 * Data is aquired by competition id or name.
	 * @param id - id or name of competition
	 * @return string array in csv format
	 */
	public String[] getResultsByCompetition(String id){
		Connection conn = connectDb();
		String[] res = getCompetitionResults(id, conn);
			try {
				conn.close();
			}
			catch (SQLException e) {
				System.out.println("Error disconnecting from database!");
				
			}
		return res;
	}
	
	String [] getCompetitionResults(String param, Connection conn){
		if (getResultsFromDB(param, conn)) {
			String[] resultArray = new String[resultList.size()];
			for (int i = 0; i < resultList.size(); i++) {
				String resultString = new String();
				resultString = getSportsmanDataFromDB(resultList.get(i).athleteId, conn);
				resultString += resultList.get(i).toString();
				resultArray[i] = resultString;
			}
			return resultArray;
		} else {
			return null;
		}
	}
	
	/**
	 * Method returns Sportsman name, date of birth and country code 
	 * by ID in database. 
	 * @param id - Sportsman id in database
	 * @param conn -  connection handler to database
	 * @return - CSV formed result string
	 */
	String getSportsmanDataFromDB(int id, Connection conn){
		
		PreparedStatement resultsStatement;
		try {
			String results;
			resultsStatement = conn.prepareStatement("select * from athletes where id=?");
			resultsStatement.setInt(1, id);
			ResultSet rs = resultsStatement.executeQuery();
			rs.next();
			results = "\""+rs.getString("name")+"\","+convertSQLDate(rs.getDate("dob"))+","+rs.getString("country_code")+",";
			return results;
		}
		catch (SQLException e) {
			System.out.println("Error accessing Sportsman data in database!");
			return null;
		}
	}
	
	class Results {
		int athleteId;
		Double race_100m;
		Double longJump;
		Double shotPut;
		Double highJump;
		Double race_400m;
		Double hurdles_110m;
		Double discusThrow;
		Double poleVault;
		Double javelinThrow;
		Double race_1500m;
		
		public String toString(){
			String retStr= race_100m.toString()+","+longJump.toString()+","+shotPut.toString()+",";
			retStr += highJump.toString()+","+race_400m.toString()+","+hurdles_110m.toString()+",";
			retStr += discusThrow.toString()+","+poleVault.toString()+","+javelinThrow.toString()+",";
			retStr += race_1500m.toString();
			return retStr;
		}
		
	}
	
	/**
	 * Method returns competition id, red from database
	 * by competition id or name. 
	 * @param param - id or name as String
	 * @return - competition id as int.
	 */
	private int getCompetitionID(String param,Connection conn){
		PreparedStatement membersStatement;
		try {
			membersStatement = conn.prepareStatement("select * from competitions where id = ? or name = ? ");
			int i = 0;
			try{
				i = Integer.parseInt(param);
			}
			catch (NumberFormatException e){
			}
		membersStatement.setInt(1, i);
		membersStatement.setString(2, param);
		
		ResultSet rs = membersStatement.executeQuery();

			if (rs.next()){
				return rs.getInt("id");
			} else {
				return 0;
			}
		}
		catch (SQLException e) {
			System.out.println("Error accessing results by competition in database!");
			return 0;
		}
	}
	
	/**
	 * Method gets sportsmen competition results by ID or name
	 * of competition in database and puts it into
	 * resultList field of PersonDAO instance. 
	 * @param param -  Sportsman id or name in database.
	 * @param conn - connection handler
	 * @return - true if succeeded of false if not. 
	 */
	boolean getResultsFromDB(String param, Connection conn){
			PreparedStatement membersStatement;
			int id = getCompetitionID(param, conn);
			if (id < 1){
				System.out.println("No competiton was found with name or id "+param);
				return false;
			}
			try {
				membersStatement = conn.prepareStatement("select * from results where competition_id = ? ");

			membersStatement.setInt(1, id);
			ResultSet rs = membersStatement.executeQuery();
			while (rs.next()){
				Results result = new Results();
				result.athleteId=rs.getInt("athlete_id");
				result.discusThrow = rs.getDouble("discus_throw");
				result.highJump = rs.getDouble("high_jump");
				result.hurdles_110m = rs.getDouble("hurdles_110m");
				result.javelinThrow = rs.getDouble("javelin_throw");
				result.longJump = rs.getDouble("long_jump");
				result.poleVault = rs.getDouble("pole_vault");
				result.race_100m = rs.getDouble("race_100m");
				result.race_1500m = rs.getDouble("race_1500m");
				result.race_400m = rs.getDouble("race_400m");
				result.shotPut = rs.getDouble("shot_put");
				resultList.add(result);
			}
			 return true;
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error accessing results by competition in database!");
				return false;
			}
	}
}
