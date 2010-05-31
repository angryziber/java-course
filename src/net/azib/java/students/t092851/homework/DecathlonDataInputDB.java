package net.azib.java.students.t092851.homework;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;


/**
 * DecathlonDataInputDB
 *
 * @author Lauri
 */
public class DecathlonDataInputDB implements DecathlonDataInput {

	private final String  competition_name;
	private final Integer competition_id;

	
	/**
	 * @param competition competition name or ID number
	 */
	public DecathlonDataInputDB(String competition) {
		Integer competition_id;
		
		try {
			competition_id = Integer.valueOf(competition);
		}
		catch (NumberFormatException e) {
			competition_id = null;
		}
		
		this.competition_id   = competition_id;
		this.competition_name = competition;
	}

	
	/**
	 * Reads decathlon competition data from database
	 * @return decathlon competition data; in case of failure returns 'null'
	 */
	@Override
	public DecathlonData readData() {
		DecathlonData     data = new DecathlonData();
		Connection        con  = null;
		PreparedStatement stmt = null;
		ResultSet         rs   = null;
		Participant       athlete;
		
		try {
			
			con = openConnection();
			
			if (competition_id == null) {
				String sql = "SELECT athletes.*, results.* FROM athletes, competitions, results " +
						"WHERE athletes.id = results.athlete_id " +
						"and results.competition_id = competitions.id " +
						"and competitions.name = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, competition_name);
			}
			else {
				String sql = "SELECT athletes.*, results.* FROM athletes, competitions, results " +
						"WHERE athletes.id = results.athlete_id " +
						"and results.competition_id = competitions.id " +
						"and (competitions.name = ? or competitions.id = ?)";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, competition_name);
				stmt.setInt(2, competition_id);				
			}
				
			rs = stmt.executeQuery();
			
			while (rs.next()) { 
				athlete = new Participant();
				athlete.setName(rs.getString("name"));
				try {
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date date = dateFormat.parse(rs.getString("dob"));
					athlete.setBirthDate(date);
				}
				catch (Exception e) {
					System.out.println("Warning: a record (id = " + rs.getString("id") + ")could not be read because date field \"dob\" was not in valid range");
					continue;
				}
				athlete.setCountry(rs.getString("country_code"));
				
				for (DecathlonEvent event: DecathlonEvent.values())
					athlete.setResult(event, rs.getDouble(event.getDatabaseHeader()));
				
				data.insert(athlete);				
			}
		}
		catch (SQLException e) {
			System.out.println("Database operation failed: " + e.toString());
			data = null;
		}
		finally {
			try {
				if (rs   != null) rs.close();                                            
			} catch (SQLException e) {
			}
			try {
				if (stmt != null) stmt.close();
			} catch (SQLException e) {
			}
			try {
				if (con  != null) con.close();
			} catch (SQLException e) {
			}
		}
		return data;
	}
	
	
	protected Connection openConnection() throws SQLException {
		ResourceBundle bundle = ResourceBundle.getBundle(DecathlonCalculator.class.getPackage().getName() + ".db");
		return DriverManager.getConnection(bundle.getString("connection"), "java", "java");
	}
	
}
