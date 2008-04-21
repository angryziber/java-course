package net.azib.java.lessons.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ActivePerson
 *
 * @author anton
 */
public class ActivePerson extends Person {
	
	public static ActivePerson load(int id) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
			PreparedStatement personStatement = conn.prepareStatement("select * from persons where id = ?");
			personStatement.setInt(1, id);
			ResultSet rs = personStatement.executeQuery();
			if (rs.next()) {
				ActivePerson person = new ActivePerson();
				person.name = new Name(rs.getString("name"));
				person.age = rs.getInt("age");
				person.sex = Sex.valueOf(rs.getString("sex"));
				return person;
			}
			else {
				throw new RuntimeException("Duplicate records found!!!");
			}
		}
		catch (SQLException e) {
			throw new RuntimeException("Error loading Person with id=" + id, e);
		}
		finally {
			if (conn != null)
				try {
					conn.close();
				}
				catch (SQLException e) {
				}
		}
	}
	
}
