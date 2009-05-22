package net.azib.java.lessons.db;

import net.azib.java.lessons.db.Person.Name;
import net.azib.java.lessons.db.Person.Sex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBCPersonDAO
 *
 * @author anton
 */
public class JDBCPersonDAO implements PersonDAO {
	public Person loadByName(String fullName) throws SQLException, StorageException {
		Connection conn = FakeDB.openConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("select id, name, age, sex from persons where name = ?");
			stmt.setString(1, fullName);
			ResultSet result = stmt.executeQuery();
			if (!result.next())
				throw new StorageException("No person with name " + fullName);
			
			return new Person(
					result.getInt("id"),
					new Name(result.getString("name")),
					result.getInt("age"),
					Sex.valueOf(result.getString("sex"))
					);
		}
		finally {
			conn.close();
		}
	}
	
	public void save(Person person) {
		throw new UnsupportedOperationException("Person saving not implemented yet");
	}
}
