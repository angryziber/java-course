package net.azib.java.lessons.basic;

/**
 * AnimalKeeper
 *
 * @author anton
 */
public class AnimalKeeper {
	public static void main(String[] args) {
		Animal d = new Dog("Muku", 1);
		Animal c = new Cat("Kiisu", 2);
		// Animal a = new Animal("what?", 3); impossible!
		
		System.out.println(d);
		d.makeNoise();
		
		System.out.println(c);
		c.makeNoise();
	}
}
