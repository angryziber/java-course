package net.azib.java.lessons.db;

import java.util.Collection;

/**
 * PersonDAO
 *
 * @author anton
 */
public interface PersonDAO {
	public Person loadPerson(int id);
	
	public Collection<Person> findAllPersons();
}
