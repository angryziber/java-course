package net.azib.java.lessons.db;

/**
 * A person
 *
 * @author anton
 */
public class Person {
	
	int id;
	Name name;
	int age;
	Sex sex;
	
	public static class Name {
		private String first;
		private String last;
		
		public Name(String fullName) {
			String[] names = fullName.split("\\s");
			first = names[0];
			last = names[names.length - 1];
		}
		
		public String toString() {
			return first + " " + last;
		}
	}
	public static enum Sex {M, F}
	
	public Person() {
	}

	public Person(Name name, int age, Sex sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name.toString();
	}
	
	void setName(String name) {
		this.name = new Name(name);
	}
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @return the sex
	 */
	public Sex getSex() {
		return sex;
	}
	
	public String toString() {
		return "Name: " + getName() + "\n" +
			   "Age:  " + getAge() + "\n" +
			   "Sex:  " + getSex() + "\n";
	}
}


