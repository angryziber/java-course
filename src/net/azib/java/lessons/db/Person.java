package net.azib.java.lessons.db;

public class Person {
	enum Sex {M, F}

	Long id;
	String name;
	int age;
	Sex sex;

	@Override
	public String toString() {
		return name + ":" + sex + ":" + age;
	}
}
