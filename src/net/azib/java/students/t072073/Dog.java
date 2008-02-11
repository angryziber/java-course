package net.azib.java.students.t072073;

/**
 * Dog
 *
 * @author t072073
 */
public class Dog {
	String name;
	
	/**
	 * @param string
	 */
	public Dog(String name) {
		this.name = name; 
	}
	public Dog() {
		name = "Unknown"; 
	}
	String getName () {
		return name;		
	}
	
	public static void main(String[] args) {
		Dog a = new Dog("Sharik");
		Dog b = new Dog("Tuzik");
		Dog c = new Dog();
		
		System.out.println("I have two dogs " + 
				a.getName() + " and " + 
				b.getName() + " and " +
				c.getName());
	}
}
