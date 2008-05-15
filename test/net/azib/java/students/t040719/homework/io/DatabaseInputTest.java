package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;



/**
 * DatabaseInputTest
 *
 * @author romi
 */
public class DatabaseInputTest {
	private Connection conn;
	private int errorCode;
	
	@Test
	public void connectionFails(){
		DatabaseInput db = new DatabaseInput(){
			@Override
			public void exit(int errorCode) {
	        	 DatabaseInputTest.this.errorCode = errorCode;
	        }
		};
		db.setJdbcPassword("wrong");
		db.openConnection();
		assertEquals(4, errorCode);
	}
	
	@Test
	public void noParametersGivenError() throws IOException{
		DatabaseInput db = new DatabaseInput(){
			@Override
			public void exit(int errorCode) {
	        	 DatabaseInputTest.this.errorCode = errorCode;
	        }
		};
		db.getResults();
		assertEquals(5, errorCode);
	}
	
	@Test
	public void testLoadingResult() throws SQLException, IOException{
		conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
		
		Statement st = conn.createStatement();
		st.execute("create table competitions (id integer, country_code varchar, date date, name varchar, location varchar)");
		st.execute("insert into competitions values (1, 'EE', '2005-12-01','Training','Tallinn')");
		st.execute("create table athletes (id integer, name varchar, dob date, country_code varchar)");
		st.execute("insert into athletes values (1, 'Siim Susi', '1976-01-01','EE')");
		st.execute("insert into athletes values (2, 'Beata Kana', '1982-02-29','ZA')");
		st.execute("create table results (id integer, athlete_id integer, competition_id integer, " +
				"race_100m float, long_jump float, shot_put float, high_jump float, race_400m " +
				"float, hurdles_110m float, discus_throw float, pole_vault float, javelin_throw " +
				"float, race_1500m float)");
		st.execute("insert into results values (1, 1, 1, 12.61, 5, 9.22, 1.5, 59.39, 16.43, 21.6, 2.6, 35.81, 325.72)");
		st.execute("insert into results values (2, 2, 1, 13.04, 4.53, 7.79, 1.55, 64.72, 18.74, 24.2, 2.4, 28.2, 410.76)");
		
		DatabaseInput dbi = new DatabaseInput() {
			@Override
			Connection openConnection(){
				return conn;
			}
		};
		List<Athlete> aths = dbi.getResults("1");
		assertEquals(7433, aths.get(0).getDecathlonPoints()+aths.get(1).getDecathlonPoints());
	}
	
	@Test
	public void testExecutionOrder() throws SQLException, IOException{
		String sql = "SELECT A.name, A.dob, A.country_code, R.race_100m, " +
		"R.long_jump, R.shot_put, R.high_jump, R.race_400m, R.hurdles_110m, " +
		"R.discus_throw, R.pole_vault, R.javelin_throw, R.race_1500m FROM " +
		"results AS R INNER JOIN athletes AS A on A.id=R.athlete_id WHERE " +
		"competition_id = (SELECT id FROM competitions WHERE id = ? or name = ?)";
		
		conn = createMock(Connection.class);
		ResultSet rs = createMock(ResultSet.class);
		PreparedStatement stmt = createMock(PreparedStatement.class);
		
		expect(conn.prepareStatement(sql)).andReturn(stmt);
		stmt.setString(1, "1");
		stmt.setString(2, "1");
		expect(stmt.executeQuery()).andReturn(rs);
		expect(rs.next()).andReturn(false).times(1);

		rs.close();
		conn.close();
		
		replay(conn, stmt, rs);
		
		DatabaseInput dbi = new DatabaseInput() {
			@Override
			Connection openConnection(){
				return conn;
			}
		};
		dbi.getResults("1");
		verify(conn, stmt, rs);
	}
	
}
