package net.azib.java.lessons.db;

/**
 * A person
 *
 * @author anton
 */
public class Person {
	enum Sex {M, F};
	
	int id;
	String name;
	int age;
	Sex sex;
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}
}


