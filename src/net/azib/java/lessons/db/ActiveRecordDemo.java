package net.azib.java.lessons.db;

import java.sql.SQLException;

public class ActiveRecordDemo {
	public static void main(String[] args) throws PersonException, SQLException {
		FakeDB.prepare();

		ActivePerson person = ActivePerson.create();
		person.name = "John Doe";
		person.age = 35;
		person.sex = Person.Sex.M;
		person.save();

		person = ActivePerson.loadByName("John Doe");
		System.out.println(person);

		person = ActivePerson.loadByName("Jaan Tamm");
		System.out.println(person);
		person.age++;
		person.save();

		System.out.println(ActivePerson.loadByName("Jaan Tamm"));
	}
}
