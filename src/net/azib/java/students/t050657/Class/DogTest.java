package net.azib.java.students.t050657.Class;

/**
 * DogTest
 *
 * @author t050657
 */
public class DogTest {

	public static void main(String[] args) {
		Dog bob = new Dog("Bobby", 12);
		Dog bobby = new Dog("Bobby", 12);

		System.out.println(bob.equals(bobby));

	}
}
