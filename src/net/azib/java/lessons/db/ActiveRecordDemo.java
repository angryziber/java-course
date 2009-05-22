package net.azib.java.lessons.db;

import java.sql.SQLException;

/**
 * ActiveRecordDemo
 *
 * @author anton
 */
public class ActiveRecordDemo {
	public static void main(String[] args) throws SQLException, StorageException {
		new FakeDB().prepare();
		
		ActivePerson p = ActivePerson.loadByName("John Doe");
		System.out.println(p);
		
		// save changed person
		p.save();
	}
}
