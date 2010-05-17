package net.azib.java.lessons.db;

import java.sql.SQLException;

/**
 * ActiveRecordDemo
 *
 * @author anton
 */
public class DAODemo {
	public static void main(String[] args) throws StorageException, SQLException {
		new FakeDB().prepare();
		
		PersonDAO dao = new JDBCPersonDAO();	
		
		Person person = dao.load("John Doe");
		System.out.println(person);
		
		person.age = 75;
		dao.save(person);
		
		person = dao.load("John Doe");
		System.out.println(person);
	}
}
