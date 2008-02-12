package net.azib.java.students.t980814;

/**
 * Dog
 * 
 * @author t980814
 */
public class Dog {
	String name;

	public Dog(String name) {
		this.name = name;
	}

	public Dog() {
		name = "Unknown";
	}

	public String getName() {
		final String newName = "Mega" + this.name;
		return newName;
	}

	public static void main(String[] args) {
		Dog a = new Dog("Sharik");
		Dog b = new Dog("Muki");
		Dog c = new Dog();
 		System.out.println(a.getName() + ", " + b.getName() + ", " + c.getName());
	}
}
