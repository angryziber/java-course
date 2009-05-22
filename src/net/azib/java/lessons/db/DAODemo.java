package net.azib.java.lessons.db;

import java.sql.SQLException;

/**
 * DAODemo
 *
 * @author anton
 */
public class DAODemo {
	public static void main(String[] args) throws SQLException, StorageException {
		new FakeDB().prepare();
		
		PersonDAO dao = new JDBCPersonDAO();
		Person person = dao.loadByName("John Doe");
		System.out.println(person);
		
		dao.save(person);
	}
}
