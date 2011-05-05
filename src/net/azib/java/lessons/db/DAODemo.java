package net.azib.java.lessons.db;

import java.sql.SQLException;

public class DAODemo {
	public static void main(String[] args) throws PersonException, SQLException {
		FakeDB.prepare();
		PersonRepository dao = new PersonRepository();

		Person person = new Person();
		person.name = "John Doe";
		person.age = 35;
		person.sex = Person.Sex.M;
		dao.save(person);

		person = dao.loadPersonByName("John Doe");
		System.out.println(person);

		person = dao.loadPersonByName("Jaan Tamm");
		System.out.println(person);
	}

}
