package net.azib.java.students.t001370.homework;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

/**
 * DecathlonInputDBTest
 *
 * @author maksim
 */
public class DecathlonInputDBTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputDB#getSQLStatement()}.
	 */
	@Test
	public void testGetSQLStatement() {
		String srt =  "SELECT a.name 		AS name, 													" +
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
						"WHERE c.id = ? OR c.name = ?"; 
		
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


}
