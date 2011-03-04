package net.azib.java.lessons.basic;

import java.io.Serializable;

public abstract class Animal implements Cloneable, Serializable {
	private int age;

	public int getAge() {
		return age;
	}

	public void becomeOlder() {
		age++;
	}

	@Override
	public Animal clone() {
		try {
			return (Animal) super.clone();
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
