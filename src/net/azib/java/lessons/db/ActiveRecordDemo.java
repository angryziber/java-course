package net.azib.java.lessons.db;

import java.sql.SQLException;

/**
 * PersonDemo
 *
 * @author anton
 */
public class ActiveRecordDemo {
	public static void main(String[] args) throws SQLException {
		new FakeDB().prepare();

		ActivePerson person = ActivePerson.load(1);
		displayPerson(person);
		
		displayPerson(ActivePerson.load(2));
	}

	/**
	 * @param person
	 */
	static void displayPerson(Person person) {
		System.out.println(person.toString());
	}
}
