package net.azib.java.students.t092859.homework.input;

import net.azib.java.students.t092859.homework.core.DecathlonResult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * DBResultFetcher
 *
 * @author konstantin
 */
public class DBResultFetcher implements DecathlonResultFetcher{

	String dbConURL;
	String dbUsername;
	String dbPass;
	String competition;

	/**
	 * @param dbConURL - URL for database connection
	 * @param dbUsername - database user name
	 * @param dbPass - database password
	 * @param competition - competition id or name
	 */
	public DBResultFetcher(String dbConURL, String dbUsername, String dbPass, String competition) {
		this.dbConURL = dbConURL;
		this.dbUsername = dbUsername;
		this.dbPass = dbPass;
		this.competition = competition;
	}

	/**
	 * Fetches decathlon results from database
	 * <br><br>If competition is passed as number, it is assumed
	 * that competition ID is passed. Otherwise competition is selected
	 * by name
	 */
	@Override
	public List<DecathlonResult> fetchResults() throws Exception {
		
		List<DecathlonResult> results = new ArrayList<DecathlonResult>();
		
		String queryString = "SELECT athletes.name, dob, athletes.country_code, " +
				"race_100m, long_jump, shot_put, high_jump, race_400m, hurdles_110m, " +
				"discus_throw, pole_vault, javelin_throw, race_1500m " +
				"FROM athletes INNER JOIN " +
				"(SELECT competition_id, athlete_id as results_athlete_id, race_100m, " +
				"long_jump, shot_put, high_jump, race_400m, hurdles_110m, discus_throw, " +
				"pole_vault, javelin_throw, race_1500m, competitions.* " +
				"FROM results INNER JOIN competitions ON results.competition_id = " +
				"competitions.id) as tbl ON athletes.id = results_athlete_id WHERE ";
		
		PreparedStatement query;
		ResultSet rs;
		int rowNumber = 0;
		
		Connection dbConnection = DriverManager.getConnection(dbConURL, dbUsername, dbPass);
		
		if(competition.matches("\\d+")) //assuming that if number is given as a parameter, then competition is selected by id
		{
			queryString += "competition_id = ?";
			query = dbConnection.prepareStatement(queryString);
			query.setInt(1, new Scanner(competition).nextInt());
		}
		else
		{
			queryString += "location = ?";
			query = dbConnection.prepareStatement(queryString);
			query.setString(1, competition);
		}

		rs = query.executeQuery();	
		
		while(rs.next())
		{
			try {
				rowNumber = rs.getRow();
				String[] params = new String[13];
				for(int i = 0; i < 13; i++)
				{
					if(i == 1){ //date input
						Date dob = rs.getDate(2);
						params[1] = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("")).format(dob);
					}
					else
						params[i] = rs.getString(i+1);
				}
				DecathlonResult result = new DecathlonResult(params);
				int incorrectParam;
				if((incorrectParam = result.getValidationResult()) == -1)
					results.add(result);
				else
					System.err.println("Could not accept result: incorrect parameter " + incorrectParam);
			}
			catch (SQLException e) {
				System.err.println("Could not parse data from DB for row " + rowNumber);
			}
		}
		
		try {
			dbConnection.close();
		}
		catch (SQLException e) {} //at least we tried
		return results;
	}

}
