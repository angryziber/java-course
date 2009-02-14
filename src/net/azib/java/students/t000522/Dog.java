package net.azib.java.students.t000522;

import java.util.Date;

public class Dog {

	private String name;
	private int age;
	private Date date = new Date();
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog named " + name + " and aged " + age + "; datetime " + date;
	}
	
}
