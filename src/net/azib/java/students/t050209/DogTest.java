package net.azib.java.students.t050209;

/**
 * DogTest
 *
 * @author t050209
 */
public class DogTest {
	public static void main(String[] args) {
		Ianimal dog = new Dog("Pitsu");
		System.out.println(dog.getName());
		
		Ianimal animal = new Dog("Pitsu");
		System.out.println(animal.getName());
		
		Object object = new Dog("Pitsu");
		System.out.println(((Ianimal)object).getName());
		System.out.println(object);
		
		Object dog1 = new Dog("Pitsu");
		Object dog2 = new Dog("Pitsu"); // = dog1 annab true
		System.out.println("koerade võrdlemine " + dog1.equals(dog2));
		System.out.println(dog1 instanceof Comparable);
	}
}
