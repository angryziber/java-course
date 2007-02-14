package net.azib.java.students.t060401;

/**
 * DogTest
 *
 * @author t060401
 */
public class DogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog1 = new Dog("Kutsu");
		Dog dog2 = new Dog("Pats");
		System.out.println(dog1.toString());
		System.out.println(dog2.toString());
		System.out.println(dog1.equals(dog2));
	}

}
