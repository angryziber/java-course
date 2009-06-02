package net.azib.java.students.t040729.homework;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.junit.Test;


/**
 * MySqlDataReaderTest
 * 
 * @author ValleTon
 */
public class MySqlDataReaderTest {
	Properties fakeDbProperties;
	
	/**
	 * Test method for {@link net.azib.java.students.t040729.homework.MySqlDataReader#getCompetitionData()}.
	 * @throws Exception 
	 */
	@Test
	public void testGetCompetitionData() throws Exception {
		fakeDbProperties = prepareFakeDbProperties();
		System.out.println("Test:"+fakeDbProperties.getProperty("sql.athletes_tbl.id"));
		
		prepareFakeDB();
		
		MySqlDataReader dataIn = new MySqlDataReader("testcompetition",fakeDbProperties);
		dataIn.setAppProperties(getFakeProperties());
		List<Athlete> a = dataIn.getCompetitionData();
		for (Athlete aa : a){
			aa.calculateTotalPoints();
		}
		
		Collections.sort(a);
		
		assertEquals("õäöü", a.get(0).getName());
		
		//CompetitionDataOut out = new ConsoleDataWriter();
		//out.putCompetitionData(a);

	}

	private Properties prepareFakeDbProperties() {
		Properties mockProperties = new Properties();
		mockProperties.setProperty("sql.connection_string", "jdbc:hsqldb:mem:DecathlonDB");
		mockProperties.setProperty("sql.user", "sa");
		mockProperties.setProperty("sql.password", "");
		mockProperties.setProperty("sql.competitions_tbl", "competitions");
		mockProperties.setProperty("sql.results_tbl", "results");
		mockProperties.setProperty("sql.athletes_tbl", "athletes");
		mockProperties.setProperty("sql.event_columns","race_100m,long_jump,shot_put,high_jump,race_400m,hurdles_110m,discus_throw,pole_vault,javelin_throw,race_1500m");
		mockProperties.setProperty("sql.competitions_tbl.id","id");
		mockProperties.setProperty("sql.competitions_tbl.name","name");
		mockProperties.setProperty("sql.results_tbl.athlete_id","athlete_id");
		mockProperties.setProperty("sql.results_tbl.competition_id","competition_id");
		mockProperties.setProperty("sql.athletes_tbl.name","name");
		mockProperties.setProperty("sql.athletes_tbl.country_code","country_code");
		mockProperties.setProperty("sql.athletes_tbl.dob","dob");
		mockProperties.setProperty("sql.athletes_tbl.id","id");
		return mockProperties;
	}

	private void prepareFakeDB() throws SQLException {
		java.sql.Connection conn = DriverManager.getConnection(fakeDbProperties.getProperty("sql.connection_string"), fakeDbProperties.getProperty("sql.user"), fakeDbProperties.getProperty("sql.password"));
		Statement stmt = conn.createStatement();
		stmt.execute("CREATE TABLE competitions (id INTEGER, name VARCHAR(40))");
		stmt.execute("CREATE TABLE athletes (id INTEGER, name VARCHAR(40), dob DATE, country_code VARCHAR(2))");
		List<String> listOfResultColumns = Arrays.asList(fakeDbProperties.getProperty("sql.event_columns").split(","));
		String tmp = "";
		for (String s : listOfResultColumns){
			tmp += ", " + s + " FLOAT";
		}
		stmt.execute("CREATE TABLE results (athlete_id INTEGER,competition_id INTEGER"+tmp+")");
		stmt.execute("INSERT INTO competitions (id,name) VALUES (1,'testcompetition')");
		stmt.execute("INSERT INTO athletes (id,name,dob,country_code) VALUES (1,'õäöü','0000-00-00','TE')");
		stmt.execute("INSERT INTO athletes (id,name,dob,country_code) VALUES (2,'World Record','1983-09-13','WR')");
		stmt.execute("INSERT INTO athletes (id,name,dob,country_code) VALUES (3,'Kolmas','2000-12-12','TE')");
		stmt.execute("INSERT INTO results VALUES (1,1,1.11,1.11,1.11,1.11,1.11,1.11,1.11,1.11,1.11,1.11)");
		stmt.execute("INSERT INTO results VALUES (2,1,9.69,8.95,23.12,2.45,43.18,12.87,74.08,6.14,98.48,206)");
		stmt.execute("INSERT INTO results VALUES (3,1,19.69,8.95,23.12,2.45,43.18,12.87,74.08,6.14,98.48,206)");
		conn.close();
	}
	
	private Properties getFakeProperties(){
		Properties fakeProperties = new Properties();
		fakeProperties.setProperty("encoding","utf-8");
		fakeProperties.setProperty("dateformat_string","dd.MM.yyyy");
		fakeProperties.setProperty("dateformat_console_short","dd.MM.yy");
		fakeProperties.setProperty("xml_dateformat_string","yyyy-MM-dd");
		return fakeProperties;
	}
}
