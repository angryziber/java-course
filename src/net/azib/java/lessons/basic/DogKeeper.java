package net.azib.java.lessons.basic;

/**
 * DogKeeper
 *
 * @author anton
 */
public class DogKeeper {
	public static void main(String[] args) {
		Dog d1 = new Dog("Muku", 1);
		Dog d2 = new Dog("Muku", 2);
		Dog d3 = new Dog("Tuku", 2);
		
		System.out.println(d1 == d2);
		System.out.println(d1.equals(d2));
		System.out.println(d1.equals(5));
		System.out.println(d1.equals(d3));
	}
}
