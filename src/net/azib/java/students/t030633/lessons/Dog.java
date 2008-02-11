package net.azib.java.students.t030633.lessons;

/**
 * Dog
 *
 * @author t030633
 */
public class Dog {
	
	String name;
	
	/**
	 * @param string
	 */
	public Dog(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	String getName() {
		String newName = "Mega " + name;
		return newName;
	}
	public static void main(String[] args) {
		Dog a = new Dog("Pontu");
		Dog b = new Dog("Tuzik");

		System.out.println("I have two dogs: " + 
				a.getName() + " and " + b.getName());
	}
}
