package net.azib.java.lessons;

/**
 * Dog
 *
 * @author anton
 */
public class Dog {
	
	String name;
	
	public Dog() {
		this.name = "Unnamed";
	}
	
	public Dog(String name) {
		this.name = name;
	}

	String getName() {
		final String newName = "Mega" + name;
		return newName;
	}
	
	public static void main(String[] args) {
		Dog a = new Dog("Sharik");
		Dog b = new Dog("Tuzik");
		Dog c = new Dog();
		
		System.out.println("I have two three: " + 
				a.getName() + ", " + b.getName() + " and " + c.getName());
	}

}
