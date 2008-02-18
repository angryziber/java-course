package net.azib.java.students.t654321;

/**
 * Dog
 * 
 * @author t999902
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
		final String newName = "Mega" + name;
		return newName;
	}
	
		String compareStrings(){
		String a;
		String b;
		a = "Hello";
		b = "Hello";
		if (a.equals(b)){
			return "OK";
		}
		return "NOK";
	}

	public static void main(String[] args) {
		Dog a = new Dog("Sharik");
		Dog b = new Dog("Muki");

		System.out.println("I have two dogs " + a.getName() + " and " + b.getName());
		System.out.println(a.compareStrings());
	}
}
