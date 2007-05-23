package net.azib.java.students.t050657.homework.src.controller;

import net.azib.java.students.t050657.homework.src.model.Athlet;
import net.azib.java.students.t050657.homework.src.model.Competition;
import net.azib.java.students.t050657.homework.src.model.DecathlonCoeficient;
import net.azib.java.students.t050657.homework.src.model.Result;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * DBAccessor
 *
 * @author Boriss
 */
public class DBAccessor {
	
	private static List<String> formatsInDB = Arrays.asList(
							   new String[] {"sec", "m", "m", "m", "min:sec",
										  	 "sec", "m", "m", "m", "min:sec"});
	protected Connection connection;
	
	protected Competition getCompetitionInfo(String date, 
			   							 String countryCode,
			   							 String description,
			   							 String url,
			   							 String user,
			   							 String password) {
		Competition comp = null;
		
		String[] compDate = date.split("-");
		
		Calendar cal = new GregorianCalendar();
		cal.setLenient(true);
		cal.set(Integer.parseInt(compDate[0]),
				Integer.parseInt(compDate[1]) - 1, 
				Integer.parseInt(compDate[2]));
		
		cal.getTime();
		
		try {
			this.initializeConnection(url, user, password);
			
			comp = this.getCompetitionFromDB(cal, countryCode, description);
			comp.setAthlets(this.getAhtletsForCompetition(comp));
			
			this.releaseConnection();
		}
		catch (ClassNotFoundException e) {
			System.out.println("mysql.jbdc.Driver not found");
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("can't get connection");
			e.printStackTrace();
		}

		return comp;
	}
	
	private void initializeConnection(String url, String user, String password) 
					throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url, user, password);
	}
	
	private void releaseConnection() throws SQLException{
		connection.close();
	}
	
	private List<Athlet> getAhtletsForCompetition(Competition competition) throws SQLException{
		List<Athlet> athlets = new ArrayList<Athlet>();
		
		PreparedStatement athIds = connection.prepareStatement("select * from results where competition_id = ?");
		athIds.setString(1, competition.getId().toString());
		ResultSet rsRes = athIds.executeQuery();
		
		PreparedStatement ath = connection.prepareStatement("select * from athletes where id = ?");
		
		Calendar cal = new GregorianCalendar();
		
		while(rsRes.next()) {
			ath.setString(1, rsRes.getString("athlete_id"));
			ResultSet rsAth = ath.executeQuery();
			
			while(rsAth.next()) {
				cal.setTime(Date.valueOf(rsAth.getString("dob")));
				Athlet athlet = new Athlet(Integer.parseInt(rsAth.getString("id")),
										   	rsAth.getString("name"),
										   	cal,
										   	rsAth.getString("country_code"));
				Result result = new Result();
				int i = 0;
				for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
					String res = rsRes.getString(i + 4);
					result.setResult(decCoef, decCoef.reduceToFormat(res, formatsInDB.get(i)));
					i++;
				}
				athlet.setResult(result);
				athlets.add(athlet);
			}
		}
		return athlets;
	}
	
	
	private Competition getCompetitionFromDB(Calendar calendar, String countryCode, String description) 
								throws SQLException{
		PreparedStatement ps = connection.prepareStatement("select * from competitions where " +
				"country_code = ? and date = ? and description = ? ");
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		ps.setString(1, countryCode);
		ps.setString(2, df.format(calendar.getTime()));
		ps.setString(3, description);
		
		ResultSet rs = ps.executeQuery();
		
		Calendar cal = new GregorianCalendar();
		
		Competition competition = null;
		while (rs.next()) {
			cal.setTime(Date.valueOf(rs.getString("date")));
			competition = new Competition(Integer.parseInt(rs.getString("id")), 
										  rs.getString("country_code"), 
										  cal, 
										  rs.getString("description"));
		}		
		return competition;
	}
	
	
}
