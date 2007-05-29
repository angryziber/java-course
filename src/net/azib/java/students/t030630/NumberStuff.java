package net.azib.java.students.t030630;

/**
 * NumberStuff
 * 
 * @author t030630
 */
public class NumberStuff {
	static int b;

	static final String HELLO = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal dog = new Dog("Rambo", (byte) 3);
		System.out.println(dog.getName() + " " + dog.getAge());
		dog.growUp();
		dog.growUp();
		System.out.println(dog.getName() + " " + dog.getAge());
		Animal doggy = new Dog("Reks");
		doggy.growUp();
		System.out.println(doggy.getName() + " " + doggy.getAge());
	}
}
