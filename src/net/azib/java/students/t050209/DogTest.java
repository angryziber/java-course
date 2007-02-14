package net.azib.java.students.t050209;

/**
 * DogTest
 *
 * @author t050209
 */
public class DogTest {
	public static void main(String[] args) {
		Dog dog = new Dog("Pitsu");
		System.out.println(dog.getName());
		
		Animal animal = new Dog("Pitsu");
		System.out.println(animal.getName());
		
		Object object = new Dog("Pitsu");
		System.out.println(((Animal)object).getName());
		System.out.println(object);
	}
}
