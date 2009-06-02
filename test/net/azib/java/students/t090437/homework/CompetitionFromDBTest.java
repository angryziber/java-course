package net.azib.java.students.t090437.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
	private void setUpTestDatabase() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:TestDB");
		
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
		
		statement.executeUpdate("INSERT INTO athletes VALUES (0, 'Erki Nool', '2005-06-25', 'EE')");
		ResultSet rs = statement.executeQuery("SELECT id FROM athletes WHERE name = 'Erki Nool'");
		rs.next();
		int athlete_id = rs.getInt(1);
		
		statement.executeUpdate("INSERT INTO competitions VALUES(0, 'AU', '2000-10-1', 'OM', 'Syndey')");
		rs = statement.executeQuery("SELECT id FROM competitions WHERE name = 'OM'");
		rs.next();
		int competition_id = rs.getInt(1);
		
		statement.executeUpdate("INSERT INTO results " +
								"VALUES(0, " + athlete_id + ", " + competition_id + ", 10.68, 7.76, 15.11, 2.00, 46.71, 14.48, 43.66, 5.00, 65.82, 269.48)");
		
	}
	
	@Test
	public void testIfReadsFromDB() throws SQLException, MyException {
		setUpTestDatabase();
		
		CompetitionDataLoader loader = new CompetitionFromDB(0);
		try {
			loader.loadData();
		} catch(Exception e) {
			Assert.assertTrue(false);
		}
		
		SortedSet<Competitor> competitors = loader.getResults();
		if(competitors.size() == 0) {
			Assert.assertTrue(false);
		}
		Competitor competitor = competitors.first();
		Assert.assertEquals(competitor.getScore(), 8641);		
	}
}
