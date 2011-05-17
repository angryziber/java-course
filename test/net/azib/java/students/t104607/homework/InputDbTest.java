package net.azib.java.students.t104607.homework;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import static junit.framework.Assert.assertEquals;

/**
 * @author 104607 IASM
 */
public class InputDbTest {
	@Before
	public void setUp() throws Exception {
		PropertyConfigurator.configure(InputDb.class.getResource("log4j.disable.properties"));

		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:TestDB", "sa", "");
		Statement stmt = conn.createStatement();
		stmt.execute("create table athletes (id integer, name varchar, dob date, country_code varchar)");
		stmt.execute("insert into athletes values(1, 'Siim Susi', '1976-01-01', 'EE')");
		stmt.execute("insert into athletes values(2, 'Beata Kana', '1989-05-09', 'ZA')");
		stmt.execute("create table competitions (id integer, country_code varchar, date date, name varchar, location varchar)");
		stmt.execute("insert into competitions values(2, 'EE', '2005-12-01', 'Training', 'Tallinn')");
		stmt.execute("create table results (id integer, athlete_id integer, competition_id integer, race_100m float, long_jump float, shot_put float, high_jump float, race_400m float, hurdles_110m float, discus_throw float, pole_vault float, javelin_throw float, race_1500m float)");
		stmt.execute("insert into results values(1, 1, 2, 12.61, 5, 9.22, 1.5, 59.39, 16.43, 21.6, 2.6, 35.81, 325.72)");
		stmt.execute("insert into results values(2, 2, 2, 13.04, 4.53, 7.79, 1.55, 64.72, 18.74, 24.2, 2.4, 28.2, 410.76)");
		conn.close();
	}

	@Test
	public void testLoad () throws Exception {
		String props = "url=jdbc:hsqldb:mem:TestDB\nuser=sa\npassword=";
		//new InputDb("Test", IOUtils.toInputStream(props));
		List<Athlete> athleteList = new InputDb().load("Training", new ByteArrayInputStream(props.getBytes()));
		assertEquals(4234, Collections.max(athleteList).getScore());
	}
}
