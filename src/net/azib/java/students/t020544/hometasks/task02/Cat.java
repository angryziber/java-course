package net.azib.java.students.t020544.hometasks.task02;

/**
 * Cat
 * 
 * @author Julija Kondratjeva
 */
public class Cat extends Animal {

	/**
	 * 
	 */
	public Cat(String name, int age, String colour) {
		super(name, age);
		this.colour = colour;
	}

	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	@Override
	public String makeSound() {
		return "Mau";
	}

	@Override
	public String toString() {
		return "I am " + getColour() + " " + super.toString();
	}

	String colour;

	public static void main(String[] args) {
		Cat c = new Cat("Kitty", 2, "black");
		System.out.println(c.toString());
	}

}
