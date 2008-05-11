package net.azib.java.lessons.db;

import java.sql.SQLException;

/**
 * DAODemo
 *
 * @author anton
 */
public class DAODemo {
	public static void main(String[] args) throws SQLException {
		new FakeDB().prepare();
		
		PersonDAO dao1 = new JDBCPersonDAO();
		PersonDAO dao2 = new HibernatePersonDAO();
		
		Person person1 = dao1.loadPerson(1);
		System.out.println(person1.toString());
		
		Person person2 = dao2.loadPerson(2);
		System.out.println(person2.toString());

		for (Person p : dao2.findAllPersons()) {
			System.out.println(p.toString());
		}
		
		// dao.savePerson(person);
		// dao.registerNewPerson(person);
	}
}
