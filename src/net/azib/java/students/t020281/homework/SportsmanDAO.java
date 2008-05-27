package net.azib.java.students.t020281.homework;

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
	String url = "jdbc:mysql://srv.azib.net:3306/decathlon";
	String user = "java";
	String password = "java";
	
	/**
	 * 
	 */
	public SportsmanDAO() {
		resultList = new ArrayList<Results>();
	}

	Connection connectDb(){
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error connecting to database!");
			return null;
		}
	}
	
	private String convertSQLDate(Date date){
		String[] arr= date.toString().split("\\-");
		return arr[2]+"."+arr[1]+"."+arr[0];
	}
	
	/**
	 * Method reads Sportsmen data to string array in CSV format from database. Data is aquired by competition id.
	 * @param competitionId
	 * @return string array in csv format
	 */
	public String[] getResultsByCompetition(int competitionId){
		if (getCompetitions(competitionId)) {
			String[] resultArray = new String[resultList.size()];
			for (int i = 0; i < resultList.size(); i++) {
				String resultString = new String();
				resultString = getSportsmanDataById (resultList.get(i).athleteId);
				resultString += resultList.get(i).toString();
				resultArray[i] = resultString;
			}
			return resultArray;
		} else {
			return null;
		}
	}
	
	private String getSportsmanDataById(int id){
		Connection conn = connectDb();
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
			// TODO Auto-generated catch block
			System.out.println("Error accessing Sportsman data in database!");
			return null;
		}
		finally {
			try {
				conn.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error disconnecting from database!");
				
			}
		}
	}
	
	private class Results {
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
	
	private boolean getCompetitions(int id){
		Connection conn = connectDb();
			PreparedStatement membersStatement;
			try {
				membersStatement = conn.prepareStatement("select * from results where competition_id = ?");

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
			finally {
				try {
					conn.close();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error disconnecting from database!");
					
				}
			}
	}
}
