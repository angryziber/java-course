package net.azib.java.lessons.db;

import net.azib.java.lessons.db.Person.Name;
import net.azib.java.lessons.db.Person.Sex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.org.apache.bcel.internal.generic.StoreInstruction;

/**
 * ActivePerson
 *
 * @author anton
 */
public class ActivePerson extends Person {
	
	private ActivePerson(int id, Name name, int age, Sex sex) {
		super(id, name, age, sex);
	}

	static ActivePerson loadByName(String fullName) throws SQLException, StorageException {
		Connection conn = FakeDB.openConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("select id, name, age, sex from persons where name = ?");
			stmt.setString(1, fullName);
			ResultSet result = stmt.executeQuery();
			if (!result.next())
				throw new StorageException("No person with name " + fullName);
			
			return new ActivePerson(
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
	
	public void save() {
		throw new UnsupportedOperationException("Person saving not implemented yet");
	}
}
