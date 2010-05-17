package net.azib.java.lessons.db;

/**
 * PersonDAO
 *
 * @author anton
 */
public interface PersonDAO {

	public abstract Person load(String name) throws StorageException;

	public abstract void save(Person person) throws StorageException;

}