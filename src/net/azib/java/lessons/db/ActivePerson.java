package net.azib.java.lessons.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static net.azib.java.lessons.db.FakeDB.closeQuietly;
import static net.azib.java.lessons.db.FakeDB.openConnection;

public class ActivePerson extends Person {
	public static ActivePerson create() {
		return new ActivePerson();
	}

	public static ActivePerson loadByName(String name) throws PersonException {
		Connection conn = null;
		try {
			conn = openConnection();
			PreparedStatement statement = conn.prepareStatement("select * from persons where name = ?");
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
			if (!rs.next())
				return null;

			ActivePerson person = new ActivePerson();
			person.id = rs.getLong("id");
			person.name = rs.getString("name");
			person.age = rs.getInt("age");
			person.sex = Sex.valueOf(rs.getString("sex"));
			return person;
		}
		catch (SQLException e) {
			throw new PersonException("Failed to load person with name " + name, e);
		}
		finally {
			closeQuietly(conn);
		}
	}

	public void save() throws PersonException {
		Connection conn = null;
		try {
			conn = openConnection();

			PreparedStatement statement;
			if (id == null)
			    statement = conn.prepareStatement("insert into persons (name, age, sex) values (?, ?, ?)");
			else
				statement = conn.prepareStatement("update persons set name = ?, age = ?, sex = ? where id = ?");

			statement.setString(1, name);
			statement.setInt(2, age);
			statement.setString(3, sex.toString());
			if (id != null)
				statement.setLong(4, id);

			statement.execute();
		}
		catch (SQLException e) {
			throw new PersonException("Failed to save " + this, e);
		}
		finally {
			closeQuietly(conn);
		}
	}
}
