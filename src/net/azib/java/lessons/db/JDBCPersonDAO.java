package net.azib.java.lessons.db;

import net.azib.java.lessons.db.Person.Name;
import net.azib.java.lessons.db.Person.Sex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * JDBCPersonDAO
 *
 * @author anton
 */
public class JDBCPersonDAO implements PersonDAO {
	
	private String jdbcURL = "jdbc:hsqldb:mem:DemoDB";
	private String jdbcUser = "sa";
	private String jdbcPassword = "";
	
	public JDBCPersonDAO() {
	}
	
	public JDBCPersonDAO(String jdbcURL, String jdbcUser, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUser = jdbcUser;
		this.jdbcPassword = jdbcPassword;
	}

	public Person loadPerson(int id) {
		Connection conn = null;
		try {
			conn = openConnection();
			PreparedStatement personStatement = conn.prepareStatement("select * from persons where id = ?");
			personStatement.setInt(1, id);
			ResultSet rs = personStatement.executeQuery();
			if (rs.next()) {
				Person person = new Person();
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

	Connection openConnection() throws SQLException {
		return DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
	}

	public Collection<Person> findAllPersons() {
		throw new UnsupportedOperationException(getClass().getName() + " doesn't support loading all Persons");
	}

}
