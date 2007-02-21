package net.azib.java.students.t030632;

/**
 * DogTest
 *
 * @author Toni
 */
public class DogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Object dog1 = new Dog("Pitsu");
		Object dog2 = new Dog("Bobik");
		Object object = new Dog("Pitsu");
		System.out.println(object);
		System.out.println(dog1 instanceof Comparable	);

	}
	

}
