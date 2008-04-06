package net.azib.java.students.t020544.hometasks.task02;

/**
 * Dog
 * 
 * @author Julija Kondratjeva
 */
public class Dog extends Animal {

	/**
	 * @param name
	 * @param age
	 */
	public Dog(String name, int age, String owner) {
		super(name, age);
		this.owner = owner;
	}

	@Override
	public String makeSound() {
		return "Bark";

	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	@Override
	public String toString() {
		return "I am " + getOwner() + "'s " + super.toString();
	}

	public static void main(String[] args) {
		Dog d = new Dog("Doggy", 3, "John");

		System.out.println(d.toString());
	}

	String owner;
}
