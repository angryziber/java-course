package net.azib.java.students.t020281.homework;


import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * SportsmanDAOTest
 *
 * @author Trial
 */
public class SportsmanDAOTest {

	
	@Test
	public void getCompetitionResultsTest(){
		try {
			prepareDB();
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:TestDB", "sa", "");
			SportsmanDAO dao= new SportsmanDAO();
			String[] strArray = dao.getCompetitionResults("2", conn);
			String expected ="\"Szőrös Szűk\",03.04.1972,HU,13.75,4.84,10.12,1.5,68.44,19.18,30.85,2.8,33.88,382.75";
			String actual = strArray[0];
			assertEquals(expected, actual);
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getSportsmanDataFromDBTest(){
		try{
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:TestDB", "sa", "");
		SportsmanDAO dao= new SportsmanDAO();
		String actual = dao.getSportsmanDataFromDB(3, conn);
		String expected = "\"Szőrös Szűk\",03.04.1972,HU,";
		assertEquals(expected, actual);
		conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getResultsFromDBTest(){
		try{
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:TestDB", "sa", "");
		SportsmanDAO dao= new SportsmanDAO();
		boolean actual = dao.getResultsFromDB("DECATHLON4BEER", conn);
		assertEquals(true, actual);
		
		String actualString = dao.resultList.get(0).toString();
		String expectedString = "13.75,4.84,10.12,1.5,68.44,19.18,30.85,2.8,33.88,382.75";
		assertEquals(expectedString, actualString);
		
		actual = dao.getResultsFromDB("1", conn);
		assertEquals(true, actual);
		
		conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void prepareDB() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:TestDB", "sa", "");
		Statement stmt = conn.createStatement();
		stmt.execute("create table athletes (id integer, name varchar, dob date, country_code varchar)");
		stmt.execute("insert into athletes values (3,'Szőrös Szűk', '1972-04-03', 'HU')");
		stmt.execute("create table competitions (id integer, country_code varchar, date date, name varchar, location varchar)");
		stmt.execute("insert into competitions values (1,'EE','2005-12-01','Training','Tallinn')");
		stmt.execute("insert into competitions values (2,'PL','2006-03-18','DECATHLON4BEER','Krakow')");
		stmt.execute("create table results (id integer, athlete_id integer, competition_id integer, race_100m float, long_jump float, shot_put float, high_jump float, race_400m float, hurdles_110m float, discus_throw float, pole_vault float, javelin_throw float, race_1500m float)");
		stmt.execute("insert into results values (3, 3, 2, 13.75, 4.84, 10.12, 1.5, 68.44, 19.18, 30.85, 2.8, 33.88, 382.75)");
		conn.close();
	}
}
