package net.azib.java.simple;

/**
 * Dog
 *
 * @author anton
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
	
	public Dog(String name) {
		this.name  = name;
	}

	public Dog(String name, byte age) {
		this.name = name;
		this.age = age;
	}
	
}
