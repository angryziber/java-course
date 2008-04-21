package net.azib.java.students.t980814.lec11;

/**
 * A person
 *
 * @author dell
 */
public class Person {
	
	protected Name name;
	protected int age;
	protected Sex sex;
	public static enum Sex {M, F};

	public static class Name {
		public String first;
		public String last;

		public Name(String fullName) {
			String[] names = fullName.split("\\s");
			first = names[0];
			last = names[names.length - 1];
		}
		
		public String toString() {
			return first + " " + last;
		}
	}
	
	public String getName() {
		return name.toString();
	}
	
	public int getAge() {
		return age;
	}
	
	public Sex getSex() {
		return sex;
	}
}

