package net.azib.java.lessons.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * PersonDemo
 *
 * @author anton
 */
public class ActiveRecordDemo {
	public static void main(String[] args) throws SQLException {
		prepareDB();

		ActivePerson person = ActivePerson.load(1);
		displayPerson(person);
		
		displayPerson(ActivePerson.load(2));
	}

	/**
	 * @param person
	 */
	static void displayPerson(Person person) {
		System.out.println("Name: " + person.getName());
		System.out.println("Age: " + person.getAge());
		System.out.println("Sex: " + person.getSex(	));
	}

	/**
	 * @throws SQLException
	 */
	static void prepareDB() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
		Statement stmt = conn.createStatement();
		stmt.execute("create table persons (id integer, name varchar, age integer, sex char)");
		stmt.execute("insert into persons values (1, 'John Doe', 25, 'M')");
		stmt.execute("insert into persons values (2, 'Jaan Tamm', 43, 'M')");
		conn.close();
	}
}
