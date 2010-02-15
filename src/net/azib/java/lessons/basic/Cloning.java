package net.azib.java.lessons.basic;

/**
 * Cloning
 *
 * @author anton
 */
public class Cloning {
	public static void main(String[] args) throws CloneNotSupportedException {
		Pet pet = new Dog("Sharik", 1);
		Pet petClone = pet.clone();
		System.out.println(petClone);
		System.out.println(pet == petClone);
	}
}
