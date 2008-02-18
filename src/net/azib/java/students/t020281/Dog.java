package net.azib.java.students.t020281;

/**
 * Dog
 *
 * @author t020281
 */
public class Dog {

	String name;
	
	/**
	 * @param string
	 */
	
	public Dog() {
		
	}
	
	public Dog(String name) {
		this.name = name;
		
		
	}
	
	String getName(){
		
		return name;
	}
	
	public static void main(String[] args) {
		
		Dog a = new Dog("Sharik");
		Dog b = new Dog("Tuzik");
		
		System.out.println("I have two dogs: " +
				a.getName() + " and " + b.getName());
		
		
	}
}
