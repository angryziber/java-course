package net.azib.java.lessons.db;

public class Person {
	enum Sex {M, F}
	Long id;

	String name;
	int age;
	Sex sex;

	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + ":" + sex + ":" + age;
	}
}
