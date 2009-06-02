package net.azib.java.students.t090437.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.SortedSet;

import junit.framework.Assert;

import org.junit.Test;


/**
 * CompetitionFromDBTest
 *
 * @author Ronald
 */
public class CompetitionFromDBTest {
	private Connection connection;
	private void setUpTestDatabase() throws SQLException {
		connection = DriverManager.getConnection("jdbc:hsqldb:mem:TestDB", "sa", "");
		
		Statement statement = connection.createStatement();
		
		statement.executeUpdate("CREATE TABLE athletes (" +
							"id int identity," +
							"name varchar(64) NOT NULL ," +
							"dob date NOT NULL ," +
							"country_code varchar(2) NOT NULL ," +
							" PRIMARY KEY  (id))");
		
		statement.executeUpdate("CREATE TABLE competitions (" +
							"id int identity, country_code varchar(2), date date NOT NULL ," +
							"name varchar(32) NOT NULL, location varchar(64) NOT NULL," +
							"PRIMARY KEY  (id))");
		
		statement.executeUpdate("CREATE TABLE results (" +
							"id int identity, athlete_id int NOT NULL, competition_id int NOT NULL," +
							"race_100m float NOT NULL, long_jump float NOT NULL, shot_put float NOT NULL," +
							"high_jump float NOT NULL, race_400m float NOT NULL, hurdles_110m float NOT NULL," +
							"discus_throw float NOT NULL, pole_vault float NOT NULL, javelin_throw float NOT NULL," +
							"race_1500m float NOT NULL, PRIMARY KEY  (id))");		
		
		statement.executeUpdate("INSERT INTO athletes(name, dob, country_code) VALUES ('Erki Nool', '2005-06-25', 'EE')");
		statement.executeUpdate("INSERT INTO competitions(country_code, date, name, location) VALUES('AU', '2000-10-1', 'OM', 'Syndey')");
		statement.executeUpdate("INSERT INTO results(athlete_id, competition_id, race_100m, long_jump, shot_put, " +
							"high_jump, race_400m, hurdles_110m, discus_throw, pole_vault, javelin_throw, race_1500m) " +
							"VALUES(0, 0, 10.68, 7.76, 15.11, 2.00, 46.71, 14.48, 43.66, 5.00, 65.82, 269.48)");
		
		
	}
	
	@Test
	public void testIfReadsFromDB() throws SQLException, MyException {
		setUpTestDatabase();
		
		CompetitionFromDB loader = new CompetitionFromDB(0);
		loader.setDbConn(connection);
		loader.loadData();
		
		SortedSet<Competitor> competitors = loader.getResults();
		Competitor competitor = competitors.first();
		Assert.assertEquals(competitor.getScore(), 8641);		
	}
}
