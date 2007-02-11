package net.azib.java.students.t020544;

/**
 * Dog
 * 
 * @author Julija Kondratjeva
 */
public class Dog {
	private String name, breed, owner;
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

	public String getBreed() {
		return breed;
	}

	public String getOwner() {
		return owner;
	}

	public Dog(String name, byte age, String breed, String owner) {
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.owner = owner;
	}

}
