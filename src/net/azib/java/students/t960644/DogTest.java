package net.azib.java.students.t960644;

/**
 * DogTest
 *
 * @author t960644
 */
public class DogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object dog1 = new Dog("Nupi");
		Object dog2 = new Dog("Nupi");
		System.out.println(dog1.equals(dog2));
		System.out.println(dog1 instanceof Comparable);
	}

}
