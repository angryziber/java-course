package net.azib.java.students.t092875.homework.readers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * FakeAthleteDB
 *
 * @author Mihhail
 */
public class FakeAthleteDB {
	public void prepare(){
		Connection conn = null;
		try{
			conn = openConnection();
			Statement stmt = conn.createStatement();
			stmt.execute("CREATE TABLE athletes(id integer, name varchar, dob date, country_code varchar)");
			stmt.execute("insert into athletes values (1, 'Mihhail Arhipov', '2001-10-10', 'EU')");
			
			stmt.execute("CREATE TABLE competitions(id integer, country_code varchar, aaa date, name varchar, location varchar)");
			stmt.execute("insert into competitions values (1, 'EU', '2020-10-10', 'Something', 'EU')");
			
			stmt.execute("CREATE TABLE results(id integer, athlete_id integer, competition_id integer, race_100m float, long_jump float,"+
					"shot_put float, high_jump float, race_400m float, hurdles_110m float, discus_throw float, pole_vault float, javelin_throw float,"+
					"race_1500m float)");
			stmt.execute("insert into results values (1, 1, 1, '50.1','50.1','50.1','50.1','50.1','50.1','50.1','50.1','50.1','50.1')");
		}catch(Exception e){
			System.out.println(e.getMessage()+"a");
		}finally{
			try{
				conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	static Connection openConnection(){
		try{
			return DriverManager.getConnection("jdbc:hsqldb:mem:FakeAthleteDB", "sa", "");
		}catch(Exception e){
			System.out.println(e.getMessage()+"a");
		}
		return null;
	}
}
