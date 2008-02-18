package net.azib.java.students.t030611;

/**
 * Dog
 *
 * @author t030611
 */

public class Dog {
	
	protected String name;
	
	
	Dog(String name) {
		this.name = name;
	}

	String getName() {
		final String newName = "Mega" + name;
		return newName;
	}
	public String toString() {
		return "Buldog " + getName();
	}
	public static void main(String[] args) {
		Dog a = new Dog("Sharik");
		Dog b = new BuDog("Tuzik");
		//Dog c = new Dog();
		
		System.out.println("I have two three: " + 
				a + ", " + b );
	}

}
