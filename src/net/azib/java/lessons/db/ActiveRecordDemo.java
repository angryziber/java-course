package net.azib.java.lessons.db;

import java.sql.SQLException;

/**
 * ActiveRecordDemo
 *
 * @author anton
 */
public class ActiveRecordDemo {
	public static void main(String[] args) throws StorageException, SQLException {
		new FakeDB().prepare();
		
		ActivePerson person = ActivePerson.load("John Doe");
		System.out.println(person);
		
		person.age = 75;
		person.save();
		
		person = ActivePerson.load("John Doe");
		System.out.println(person);
	}
}
