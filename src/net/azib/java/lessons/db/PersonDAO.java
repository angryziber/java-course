package net.azib.java.lessons.db;

import java.sql.SQLException;

/**
 * PersonDAO
 *
 * @author anton
 */
public interface PersonDAO {
	public Person loadByName(String fullName) throws StorageException, SQLException;
	
	public void save(Person person) throws StorageException;
}
