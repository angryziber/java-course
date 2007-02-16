package net.azib.java.students.t020544;

/**
 * Dog
 * 
 * @author Julija Kondratjeva
 */
public class Dog {
	private String name;
	private byte age;

	public String getName() {
		return name;
	}

	public void growUp() {
		age++;
	}

	public byte getAge() {
		return age;
	}

	public Dog(byte age) {
		this.age = age;

	}

	public Dog(String name, byte age) {
		this.name = name;
		this.age = age;

	}

}
