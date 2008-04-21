package net.azib.java.students.t980814.lec11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * PersonDemo
 *
 * @author dell
 */
public class PersonDemo {

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
		Statement stmt = conn.createStatement();
		stmt.execute("create table persons (id integer, name varchar, age integer)");
		stmt.execute("insert into persons values (1, 'John Doe', 25)");
		stmt.execute("insert into persons values (2, 'Jaan Tamm', 43)");
		conn.close();

		ActivePerson person = ActivePerson.load(1);
		System.out.println(person.getName() + " (" + person.getAge() + ")");

	
		// Soovitav kasutada DAO patternit ActiveRecordi asemel, vaata näidet lessons.db alt.
	}
}
