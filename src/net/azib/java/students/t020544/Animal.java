package net.azib.java.students.t020544;

/**
 * Animal
 * 
 * @author Julija Kondratjeva
 */
public class Animal {
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

	public Animal(byte age) {
		this.age = age;

	}

	public Animal(String name, byte age) {
		this.name = name;
		this.age = age;

	}

}
