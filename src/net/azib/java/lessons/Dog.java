package net.azib.java.lessons;

/**
 * Dog
 *
 * @author anton
 */
public class Dog {
	
	protected String name;
	
	Dog(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		final String newName = "Mega" + name;
		return newName;
	}
	
	@Override
	public final String toString() {
		return "Dog: " + getName(); 
	}

	
}
