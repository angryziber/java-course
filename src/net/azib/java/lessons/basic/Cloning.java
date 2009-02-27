package net.azib.java.lessons.basic;

/**
 * Cloning
 *
 * @author anton
 */
public class Cloning {
	public static void main(String[] args) throws CloneNotSupportedException {
		Animal animal = new Dog("Dolly", 23);
		
		testClone(animal);
		
		System.out.println(new Cloning());
		System.out.println(new Cloning().toString());
	}

	private static void testClone(Animal animal) throws CloneNotSupportedException {
		Animal clone = animal.clone();
		
		System.out.println(animal == clone);
		System.out.println(animal.equals(clone));
		System.out.println(clone);
	}
}
