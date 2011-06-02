package net.azib.java.students.t100228.Homework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Fetches competition results from a database
 * @author Martin
 */
public class DbResultsFetcher {
	/**
	 * Reads competition results from a database into an {@link ArrayList} of {@link Record}s
	 * @param listResults {@link ArrayList} of {@link Record}s which is populated with competition results from the DB
	 * @param competitionIdOrName String which identifies the specific competition in the database
	 * @throws Exception
	 */
	public void fetchResults(ArrayList<Record> listResults, String competitionIdOrName) throws Exception{
		Properties dbProperties = new Properties();
		InputStream is = getClass().getResourceAsStream("src/net/azib/java/students/t100228/homework/db.properties");
		dbProperties.load(is);

		is.close();
		Connection dbConn = DriverManager.getConnection(dbProperties.getProperty("dburi"), dbProperties.getProperty("dbuser"),
			dbProperties.getProperty("dbpassword"));

		Statement statement = dbConn.createStatement();

		String dbQuery;
		try
		{
			// competition ID was given
			Integer.parseInt(competitionIdOrName);
			dbQuery = "SELECT * FROM results INNER JOIN athletes ON results.athlete_id = athletes.id WHERE competition_id =" +
					" " + competitionIdOrName + ";";
		}
		catch (NumberFormatException nfe)
		{
			// competition name was given
			dbQuery = "SELECT * FROM results INNER JOIN athletes ON results.athlete_id = athletes.id INNER JOIN competitions" +
					" ON results.competition_id = competitions.id WHERE competitions.name = '" + competitionIdOrName + "';";
		}

		ResultSet rs = statement.executeQuery(dbQuery);
		while (rs.next())
		{
			Record record = new Record();
			record.setName(rs.getString("athletes.name"));
			record.setBirthDate(java.sql.Date.valueOf(rs.getString("athletes.dob")).toString());
			record.setNationality(rs.getString("athletes.country_code"));

			record.setHundredMResult(rs.getFloat("results.race_100m"));
			record.setLongJumpResult(rs.getFloat("results.long_jump"));
			record.setShotPutResult((rs.getFloat("results.shot_put")));
			record.setHighJumpResult(rs.getFloat("results.high_jump"));
			record.setFourHundredMResult(new Float(rs.getFloat("results.race_400m")).toString());
			record.setOneHundredTenResult(rs.getFloat("results.hurdles_110m"));
			record.setDiscusResult(rs.getFloat("results.discus_throw"));
			record.setPoleVaultResult(rs.getFloat("results.pole_vault"));
			record.setJavelinResult(rs.getFloat("results.javelin_throw"));
			record.setThousandFiveHundredResult(new Float(rs.getFloat("results.race_1500m")).toString());
			listResults.add(record);
		}
		dbConn.close();
	}
}
