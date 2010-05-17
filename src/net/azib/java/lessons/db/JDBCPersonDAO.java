package net.azib.java.lessons.db;

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
	public Person load(String name) throws StorageException {
		Connection conn = null;
		try {
			conn = FakeDB.openConnection();
			
			PreparedStatement statement = conn.prepareStatement("select * from persons where name = ?");
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
			
			if (!rs.next())
				return null;
			
			Person person = new Person();
			person.id = rs.getInt("id");
			person.name = rs.getString("name");
			person.age = rs.getInt("age");
			person.sex = Sex.valueOf(rs.getString("sex"));			
			return person;
		}
		catch (SQLException e) {
			throw new StorageException("unable to load person with name " + name, e);
		}
		finally {
			if (conn != null)
				try {
					conn.close();
				}
				catch (SQLException e) {}
		}
	}
	
	public void save(Person person) throws StorageException {
		Connection conn = null;
		try {
			conn = FakeDB.openConnection();
	
			PreparedStatement statement = conn.prepareStatement("update persons set name=?, age=?, sex=? where id=?");
			statement.setString(1, person.name);
			statement.setInt(2, person.age);
			statement.setString(3, person.sex.toString());
			statement.setInt(4, person.id);
			
			statement.execute();
		}
		catch (SQLException e) {
			throw new StorageException("unable to save " + person, e);
		}
		finally {
			if (conn != null)
				try {
					conn.close();
				}
				catch (SQLException e) {}
		}
	}

}
