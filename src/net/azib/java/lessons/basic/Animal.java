package net.azib.java.lessons.basic;

public abstract class Animal {
	private int age;

	public int getAge() {
		return age;
	}

	public void becomeOlder() {
		age++;
	}
}
