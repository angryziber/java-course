package net.azib.java.lessons.db;

/**
 * A person
 *
 * @author anton
 */
public class Person {
	
	public static class Name {
		public String first;
		public String last;
	}
	public static enum Sex {M, F};
	
	private String firstName;
	private String lastName;
	private int age;
	private Sex sex;
}
