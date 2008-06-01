package net.azib.java.students.t001370.homework;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DecathlonInputDBTest
 *
 * @author maksim
 */
public class DecathlonInputDBTest {
	
	/**
	 * Make fake db using hsqldb
	 * @throws SQLException
	 */
	@Before
	public void makeFakeDB() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
		Statement stmt = conn.createStatement();
		
		//create athletes table and insert values
		stmt.execute("create table athletes (" +
				"id 			integer, " +
				"name 			varchar, " +
				"dob 			date, " +
				"country_code 	char)");
		stmt.execute("insert into athletes values (1,'Siim Susi','1976-01-01','EE')");
		stmt.execute("insert into athletes values (2,'Beata Kana','1982-02-29','ZA')");
		stmt.execute("insert into athletes values (3,'Szőrös Szűk','1972-04-03','HU')");
		
		//create competitions table and insert values
		stmt.execute("create table competitions (" +
				"id 			integer, " +
				"country_code 	varchar, " +
				"date 			date, " +
				"name 			varchar, " +
				"location 		varchar)");
		stmt.execute("insert into competitions values (1,'EE','2005-12-01','Training','Tallinn')");
		stmt.execute("insert into competitions values (2,'PL','2006-03-18','DECATHLON4BEER','Krakow')");
		stmt.execute("insert into competitions values (3,'EE','2005-12-01','Training','Tallinn2')");
		stmt.execute("insert into competitions values (4,'EE','2005-12-01','1','Tallinn2')");
		
		//create results table and insert values
		stmt.execute("create table results (" +
				"id 			integer, " +
				"athlete_id 	integer," +
				"competition_id	integer," +
				"race_100m  	float," +
				"long_jump 		float," +
				"shot_put 		float," +
				"high_jump 		float," +
				"race_400m 		float," +
				"hurdles_110m 	float," +
				"discus_throw 	float," +
				"pole_vault 	float," +
				"javelin_throw 	float," +
				"race_1500m 	float)");
		stmt.execute("insert into results values (1,1,2,12.61,5,9.22,1.5,59.39,16.43,21.6,2.6,35.81,325.72)");
		stmt.execute("insert into results values (2,2,2,13.04,4.53,7.79,1.55,64.72,18.74,24.2,2.4,28.2,410.76)");
		stmt.execute("insert into results values (3,3,2,13.75,4.84,10.12,1.5,68.44,19.18,30.85,2.8,33.88,382.75)");

		
		conn.close();
	}

	
	/**
	 * 
	 * @return properties
	 */
	private Properties getProperties() {
		Properties pr = new Properties();
		pr.setProperty("db.subprotocol", "hsqldb");
		pr.setProperty("db.subname", "mem:DemoDB");
		pr.setProperty("db.username", "sa");
		pr.setProperty("db.password", "");
		
		return pr;
	}

	/**
	 * Shutdown DB
	 * @throws SQLException
	 */
	@After
	public void shutdownDB() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
		Statement stmt = conn.createStatement();
		stmt.execute("shutdown");
		conn.close();
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputDB#getSQLStatement()}.
	 */
	@Test
	public void testGetSQLStatement() {
		//!!!! hsqldb does not support following sql statement, though other db's do!!!!!!
		//have to use old style inner join statement
		/*String srt =  "SELECT a.name 		AS name, 													" +
						"       a.dob 			AS birthday, 											" +
						"       a.country_code 	AS country_code,										" +
						"       r.race_100m 	AS race_100m,											" +
						"       r.long_jump 	AS long_jump,											" +
						"       r.shot_put 		AS shot_put,											" +
						"       r.high_jump 	AS high_jump,											" +
						"       r.race_400m 	AS race_400m,											" +
						"       r.hurdles_110m 	AS hurdles_110m,										" +
						"       r.discus_throw 	AS discus_throw,										" +
						"       r.pole_vault 	AS pole_vault,											" +
						"       r.javelin_throw AS javelin_throw,										" +
						"       r.race_1500m 	AS race_1500m											" +
						"FROM (athletes AS a INNER JOIN results AS r ON a.id = r.athlete_id) 			" +
						"                    INNER JOIN competitions AS c ON r.competition_id = c.id 	" + 
						"WHERE c.id = ? OR c.name = ?"; */
		//have to use following statement to be able to make db unit tests using hsqldb
		String srt = "SELECT a.name 		AS name, 													" +
						"       a.dob 			AS birthday, 											" +
						"       a.country_code 	AS country_code,										" +
						"       r.race_100m 	AS race_100m,											" +
						"       r.long_jump 	AS long_jump,											" +
						"       r.shot_put 		AS shot_put,											" +
						"       r.high_jump 	AS high_jump,											" +
						"       r.race_400m 	AS race_400m,											" +
						"       r.hurdles_110m 	AS hurdles_110m,										" +
						"       r.discus_throw 	AS discus_throw,										" +
						"       r.pole_vault 	AS pole_vault,											" +
						"       r.javelin_throw AS javelin_throw,										" +
						"       r.race_1500m 	AS race_1500m											" +
						"FROM athletes AS a,results AS r,competitions AS c  							" +
						"WHERE a.id = r.athlete_id AND 													" +
						"      r.competition_id = c.id  AND												" +
						"      (c.id = ? OR c.name = ?)"; 
		
		assertEquals(srt, new DecathlonInputDB().getSQLStatement());
	}
	
	@Test
	public void testDBProperties() throws IOException {
		Properties pr = new Properties();
		pr.load(DecathlonDataReader.class.getResourceAsStream("db.properties"));
		
		assertTrue(pr.containsKey((String)"db.subprotocol") == true);
		assertTrue(pr.containsKey((String)"db.subname") == true);
		assertTrue(pr.containsKey((String)"db.username") == true);
		assertTrue(pr.containsKey((String)"db.password") == true);
	}

	@Test
	public void testGetAthletesDataFromDB() throws DecathlonException, SQLException{
		
		Collection<Athlete> competitors = new DecathlonInputDB().getAthletesDataFromDB("2", getProperties());
	
		assertTrue(competitors != null);
		
		String s = "";
		for (Athlete athlete : competitors) {
			s += athlete.getName()+ "=" + athlete.competitionResults.getTotalScore() + ";"; 
		}
		
		assertEquals("Siim Susi=4234;Szőrös Szűk=3495;Beata Kana=3199;", s);
	}

	@Test
	public void testGetAthletesDataFromDBNoData() throws DecathlonException, SQLException{
		
		Collection<Athlete> competitors = new DecathlonInputDB().getAthletesDataFromDB("1", getProperties());
	
		assertTrue(competitors.size() == 0);
	}
}
