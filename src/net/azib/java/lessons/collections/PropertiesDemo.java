package net.azib.java.lessons.collections;

/**
 * PropertiesDemo
 *
 * @author anton
 */
public class PropertiesDemo {
	public static void main(String[] args) {
		System.out.println("I am running on " + System.getProperty("os.name"));
		
		String someValue = System.getProperty("someValue");
		System.out.println("User's specified value: " + someValue);
	}
}
