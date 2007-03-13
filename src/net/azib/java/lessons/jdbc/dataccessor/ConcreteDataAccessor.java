package net.azib.java.lessons.jdbc.dataccessor;

/**
 * ConcreteDataAccessor
 *
 * @author ant
 */
public class ConcreteDataAccessor implements DataAccessor {

	public Object getData() {
		return new Object();
	}

	public void save(Object object) {
		System.out.println("save(" +object+ ")");
	}

}
