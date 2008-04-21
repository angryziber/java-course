package net.azib.java.lessons.db;

import java.sql.SQLException;

/**
 * DAODemo
 *
 * @author anton
 */
public class DAODemo {
	public static void main(String[] args) throws SQLException {
		ActiveRecordDemo.prepareDB();		
		PersonDAO dao1 = new JDBCPersonDAO();
		PersonDAO dao2 = new HibernatePersonDAO();
		
		Person person1 = dao1.loadPerson(1);
		ActiveRecordDemo.displayPerson(person1);
		
		Person person2 = dao2.loadPerson(2);
		ActiveRecordDemo.displayPerson(person2);

		for (Person p : dao2.findAllPersons()) {
			ActiveRecordDemo.displayPerson(p);
		}
		
		// dao.savePerson(person);
		// dao.registerNewPerson(person);
	}
}
