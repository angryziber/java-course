package net.azib.java.lessons.jdbc.dataccessor;

/**
 * DataAccessor
 *
 * @author ant
 */
public interface DataAccessor {

	/**
	 * 
	 * 
	 * @return
	 */
	Object getData();

	/**
	 * @param object
	 */
	void save(Object object);

}
